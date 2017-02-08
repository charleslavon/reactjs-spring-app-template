import webpack from 'webpack';
import path from 'path';
import HtmlWebpackPlugin from 'html-webpack-plugin';
import CopyWebpackPlugin from 'copy-webpack-plugin';

export default {
    debug: true,
    devtool: 'source-map',
    noInfo: true,
    entry: [
        'webpack-hot-middleware/client?reload=true',
        './app/index',
    ],
    target: 'web',
    node: {  //setting these as a workaround for a conflict with the library 'request' https://github.com/request/request/issues/1691
        fs: 'empty',
        net: 'empty',
        tls: 'empty'
    },
    output: {
        path: `${__dirname}/webapp/WEB-INF`,
        publicPath: '/',
        filename: 'bundle.js'
    },
    plugins: [
        new webpack.DefinePlugin({
            'process.env.NODE_ENV': JSON.stringify('development'),
            __DEV__: true
        }),
        new webpack.HotModuleReplacementPlugin(),
        new webpack.NoErrorsPlugin(),
        new HtmlWebpackPlugin({ // Create HTML file that includes references to bundled CSS and JS.
            template: 'app/index.html',
            minify: {
                removeComments: true,
                collapseWhitespace: true
            },
            inject: true
        }),
        /* this product current doesn't have any bower configs but leaving this here as an example of how to incorporate bower with webpack */
        new CopyWebpackPlugin(
            [   {from:'bower_components/web*/*.html'},
                {from:'bower_components/web*/*.js'},
                {from:'bower_components/neon-*/**/*.html'},
                {from:'bower_components/iron-*/*.html'},
                {from:'bower_components/paper-*/*.html'},
                {from:'bower_components/font-*/*.html'},
                {from:'bower_components/polymer/*.html'}
            ]
        )
    ],
    module: {
        loaders: [
            { test: /\.json$/, loader: 'json' },
            { test: /\.js$/, include: path.join(__dirname, 'app'), loaders: ['babel'] },
            { test: /\.eot(\?v=\d+.\d+.\d+)?$/, loader: 'file' },
            { test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/, loader: "url-loader?limit=10000&mimetype=application/font-woff" },
            { test: /\.ttf(\?v=\d+.\d+.\d+)?$/, loader: 'file-loader?limit=10000&mimetype=application/octet-stream' },
            { test: /\.svg(\?v=\d+.\d+.\d+)?$/, loader: 'file-loader?limit=10000&mimetype=image/svg+xml' },
            { test: /\.(jpe?g|png|gif)$/i, loader: 'file-loader?name=[name].[ext]' },
            { test: /\.ico$/, loader: 'file-loader?name=[name].[ext]' },
            { test: /(\.css|\.scss)$/, loaders: ["style-loader", "css-loader", "sass-loader"] }
        ]
    },
    resolve: {
        extensions: ['', '.js', '.jsx', ]
    },
    devServer: {
        historyApiFallback: true,
        contentBase: './app'
    }
};
