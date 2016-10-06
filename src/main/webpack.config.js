
var webpack = require ('webpack'),
    ExtractTextPlugin = require('extract-text-webpack-plugin'),
    OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');

module.exports = {
	debug:true,
	devtool:'cheap-module-source-map',
	noInfo:false,
	entry:'./app/js/index',
	target:'web',
	output:{
	  path: './webapp',
	  publicPath:'/',
	  filename:'bundle.js',
	
     },
 	sassLoader: {
         includePaths: [ './app/css/sass' ]
     },
    stats: {
	      colors: true
    },
    plugins:[
            new webpack.DefinePlugin({ 'process.env': {'NODE_ENV': JSON.stringify('production') }}),
            new webpack.optimize.OccurenceOrderPlugin(),
            new webpack.optimize.DedupePlugin(),
            new webpack.optimize.UglifyJsPlugin(),
            new ExtractTextPlugin("app.css"),
            new OptimizeCssAssetsPlugin({
                cssProcessor: require('cssnano'),
                cssProcessorOptions: { discardComments: {removeAll: true } },
                canPrint: true
              })
            ],
            
   module:{
	 loaders:[
	          {exclude: /node_modules/, loader: 'babel', query: {compact: false} },
	          {test: /\.scss$/,  loader: ExtractTextPlugin.extract('style','css?sourceMap!sass?sourceMap')},
	          { test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000' }
	          ]
   },
   resolve: {
	    extensions: ['', '.js', '.jsx']
	},
    devServer: {
	    historyApiFallback: true,
	    contentBase: '/'
	  }

}