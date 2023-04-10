const { defineConfig } = require('@vue/cli-service')
module.exports = {
    devServer: {
        proxy: {
            '/data': {
                target: 'http://localhost:8081',
                changeOrigin: true,
//                pathRewrite: {
//                    '^/data': ''
//                }
            }
        }
    }
}
