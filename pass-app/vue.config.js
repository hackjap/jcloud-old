const { defineConfig } = require("@vue/cli-service");
const NodePolyfillPlugin = require("node-polyfill-webpack-plugin");

module.exports = defineConfig({
  transpileDependencies: true,
  configureWebpack: {
    plugins: [new NodePolyfillPlugin()],
    optimization: {
      splitChunks: {
        chunks: "all",
      },
    },
  },
  // configureWebpack: {
  //   // Node.js 모듈을 외부에서 로드하도록 설정
  //   externals: [nodeExternals()],
  //   module: {
  //     rules: [
  //       {
  //         test: /\.js$/,
  //         exclude: /node_modules/,
  //         use: {
  //           loader: "babel-loader",
  //           options: {
  //             presets: ["@babel/preset-env"],
  //           },
  //         },
  //       },
  //     ],
  //   },
  // },
});
