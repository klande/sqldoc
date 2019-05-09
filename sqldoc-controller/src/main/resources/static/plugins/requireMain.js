/**
 * Created by YM10106 on 2018/3/29.
 */
require.config({
    baseUrl: "/plugins",
    paths: {
        jquery: "jQuery/jQuery-2.2.0.min",
        bootstrap: "bootstrap/js/bootstrap.min",
        iCheck: "iCheck/icheck",
        utils: "../js/model/utils"
    },
    shim: {
        bootstrap: ['jquery'],
        iCheck: ['jquery'],
        utils: ['jquery']
    }
});