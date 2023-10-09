package com.example.demo.common

import org.springframework.validation.BindingResult

data class R<T>(
    val code: Int = 0,
    val msg: String = "",
    var data: T? = null,
    val errMsg: String? = ""
) {
    companion object {
        fun <T> ok(data: T? = null): R<T> {
            return R(0, "ok", data)
        }

//        /**
//         * 成功返回列表
//         */
//        fun <T> okList(list: List<T>, count: Long = 0): R<ListData<T>> {
//            return ok(ListData(list, count))
//        }

        /**
         * 参数错误
         */
        fun paramError(msg: String? = null, errMsg: String? = null): R<Any?> {
            return R(
                code = AppErrorCode.PARAM_ERR.code,
                msg = msg ?: AppErrorCode.PARAM_ERR.msg,
                errMsg = errMsg
            )
        }

        /**
         * 服务器错误
         */
        fun serverError(msg: String? = null, errMsg: String? = null): R<Any?> {
            val errorCode = AppErrorCode.SERVER_ERROR

            return R(errorCode.code, msg ?: errorCode.msg, null, errMsg)
        }

        // 参数校验失败错误
        fun bindingResultError(bindingResult: BindingResult): R<Any?> {
            val errorCode = AppErrorCode.PARAM_ERR

            return R(errorCode.code, bindingResult.allErrors[0].defaultMessage ?: errorCode.msg)
        }

        // 操作失败
        fun actionFail(msg: String? = null, errMsg: String? = null): R<Any?> {
            val errorCode = AppErrorCode.ACTION_FAIL

            return R(errorCode.code, msg ?: errorCode.msg, errMsg)
        }

        /**
         * 资源重复错误
         */
        fun repeatedResourceError(msg: String? = null, errMsg: String? = null): R<Any?> {
            val errorCode = AppErrorCode.REPEATED_SOURCE

            return R(errorCode.code, msg ?: errorCode.msg, errMsg)
        }

        fun forbiddenError(): R<Any?> {
            val code = AppErrorCode.FORBIDDEN

            return R(code.code, code.msg)
        }

        // 返回code错误
        fun errCode(e: AppErrorCode): R<Any?> {
            return R(e.code, e.msg)
        }
    }
}
