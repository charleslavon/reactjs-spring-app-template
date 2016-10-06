#!/bin/bash

export RUN_USER=tomcat

export PLATFORM_HOME=|||platform_home|||
export MAKE_HOME=|||make_home|||
export JRE_HOME=|||java_home|||
export PATH=|||dcs_home|||/bin:$PATH

export CATALINA_HOME=|||catalina_home|||
export CATALINA_BASE=|||make_home|||/|||web_dir|||
export CATALINA_OUT=|||catalina_out|||
export CATALINA_PID=|||catalina_pid|||
export CATALINA_TMPDIR=|||catalina_temp|||

export SHUTDOWN_PORT=|||shutdown_port|||
export CONNECTOR_PORT=|||connector_port|||
export JMX_PORT=|||jmx_port|||
export RMI_HOSTNAME=`perl -e 'print +( split "/", ( split " ", ( grep { /inet / && ! /127\.0\.0/ } \`/sbin/ip addr show\`)[0] )[1] )[0] '`

export CATALINA_OPTS="\
  -Dshutdown.port=$SHUTDOWN_PORT \
  -Dconnector.port=$CONNECTOR_PORT \
  -Dcom.sun.management.jmxremote \
  -Dcom.sun.management.jmxremote.port=$JMX_PORT \
  -Dcom.sun.management.jmxremote.ssl=false \
  -Dcom.sun.management.jmxremote.authenticate=false \
  -Djava.rmi.server.hostname=$RMI_HOSTNAME"

export JAVA_OPTS="-Dshutdown.port=$SHUTDOWN_PORT"

if [[ ! -f |||env_properties||| ]]; then
  echo
  echo "error:  Missing environment properties [ |||env_properties||| ]"
  echo
  exit 1
fi

if [[ ! -f |||datasource_properties||| ]]; then
  echo
  echo "error:  Missing datasource properties [ |||datasource_properties||| ]"
  echo
  exit 1
fi


. $CATALINA_BASE/init_includes.sh

function start {
  su $RUN_USER $CATALINA_HOME/bin/startup.sh
}

function stop {
  COUNT=1
  while status 1>/dev/null; do
    su $RUN_USER $CATALINA_HOME/bin/shutdown.sh
    echo Waiting for Tomcat instance to close.
    sleep 1
    if [ $COUNT -gt 5 ]; then kill -9 `cat $CATALINA_PID`; fi
    COUNT=$(( $COUNT + 1 ))
  done
}

function log {
  tail -f $CATALINA_OUT
}

function pid {
  if [ -f $CATALINA_PID ]
  then
    cat $CATALINA_PID
  else
    echo "File not found: $CATALINA_PID"
    exit 1
  fi
}

function restart {
  stop
  start
}

function status {
    [ -f $CATALINA_PID ] && ( PID=`cat $CATALINA_PID`; [ -d /proc/$PID ] && ( echo Tomcat at $CATALINA_BASE is running on port $CONNECTOR_PORT.; true ) ) || ( echo No PID file found.  Process not running or orphaned.; false )
}

case $1 in
  start )
    start ;;
  stop )
    stop ;;
  log )
    log ;;
  pid )
    pid ;;
  restart )
    restart ;;
  status )
    status ;;
  * )
    echo "Usage: $0 [ start | stop | restart | status | log | pid ]"
    exit
esac
