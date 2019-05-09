/**
 * Created by YM10106 on 2018/3/29.
 */
(function (define) {
    define(['jquery'], function ($) {
        /**
         * 自定义post 请求参数
         * @type {{url: null, asyns: boolean, data: null, dataType: string, method: string, sussess: sussess, error: error}}
         */
        var defaultOptions = {
            url: null,
            asyns: true,
            data: null,
            dataType: 'JSON',
            type: 'post',
            sussess: function () {
            },
            error: function (data) {
                alert("系统忙请稍后!");
            }
        };

        /**
         * 自定义ajax请求
         * @param options
         */
        var ajax = function (options) {
            options = options || {};
            options = $.extend({}, defaultOptions, options);
            $.ajax({
                url: options.url + '?timestamp=' + Date.parse(new Date()),
                asyns: options.asyns,
                data: options.data,
                dataType: options.dataType,
                type: options.type,
                success: function (data) {
                    options.sussess.call(this, data);
                },
                error: function (data) {
                    options.error.call(this, data);
                }
            });
        };
        /**
         * post 请求
         * @param url
         * @param data
         * @param callback
         * @param type
         */
        var post = function (url, data, callback, type) {
            //如果省略了数据参数，则转换参数。
            if ($.isFunction(data)) {
                type = type || callback;
                callback = data;
                data = undefined;
            }
            defaultOptions.url = url;
            defaultOptions.data = data;
            defaultOptions.sussess = callback;
            defaultOptions.dataType = type;
            ajax(defaultOptions);

        }
        /**
         * 判断对象是否为空
         * @param value
         */
        var isNull = function (value) {
            var validate = /(null|undefined|^(?![\s\S]))/.test(value);
            return validate;
        };
        /**
         * 判断非空对象
         * @type {boolean}
         */
        var isNotNull = function (value) {
            return !isNull(value);
        }

        return {
            post: post,
            ajax: ajax,
            isNotNull: isNotNull,
            isNull: isNull
        }
    });
})(typeof define === 'function' && define.amd ? define : function (deps, factory) {
    if (typeof module !== 'undefined' && module.exports) {// 判断Node
        module.exports = factory(require('jquery'));
    } else {
        window['utils'] = factory(jQuery);
    }
});