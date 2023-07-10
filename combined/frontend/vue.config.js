const { defineConfig } = require('@vue/cli-service')
module.exports = {
    devServer: {
        proxy: {
            '/vue': {
                target: 'http://localhost:8081',
                changeOrigin: true, // cross origin
            }
        }
    }
}
