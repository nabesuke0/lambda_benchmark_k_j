package jp.co.valus.lambda_benchmark

/**
 * GitHub API Test
 */
fun main(args: Array<String>) {
    println("start")

    val accessToken = args[0]
    GithubActionsDeployService(accessToken).deployLambda("production")

    println("end")
}