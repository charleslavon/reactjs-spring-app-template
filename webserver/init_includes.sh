
export JAVA_OPTS="$JAVA_OPTS  -Xmx1500m \
  -XX:PermSize=64m \
  -XX:MaxPermSize=128m"

oscache_dir=$CATALINA_BASE/work/oscache

[ -d $oscache_dir ] || ( mkdir -p $oscache_dir && chown -R $RUN_USER: $oscache_dir )

