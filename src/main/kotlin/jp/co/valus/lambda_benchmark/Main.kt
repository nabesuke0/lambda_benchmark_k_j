package jp.co.valus.lambda_benchmark

class Main {
    companion object {
        /**
         * GitHub API Test
         */
        @JvmStatic
        fun main(args: Array<String>) {
            println("start")

            val accessToken = args[0]
            GithubActionsDeployService(accessToken).deployLambda("production")

            println("end")
        }
    }
}