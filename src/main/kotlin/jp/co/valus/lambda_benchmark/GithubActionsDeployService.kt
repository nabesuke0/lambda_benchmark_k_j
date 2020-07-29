package jp.co.valus.lambda_benchmark

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.eclipse.egit.github.core.client.GitHubClient


class GithubActionsDeployService(githubAccessToken: String) {

    companion object {
        private const val GITHUB_URI_DEPLOYMENT = "/repos/nabesuke0/lambda_benchmark_k_j/deployments"
    }

    private val githubClient = GitHubClient().apply {
        setOAuth2Token(githubAccessToken)
    }

    fun deployLambda(environment: String) {
        println("deployLambda : $environment")

        try {
            githubClient.post<DeployRequest>(
                GITHUB_URI_DEPLOYMENT,
                DeployRequest(
                    payload = "deploy lambda",
                    description = "deployment : $environment build"
                ),
                DeployRequest::class.java
            )
        } catch (e: Exception) {
            println("deploy failure : " + e.localizedMessage)
        }
    }

    @JsonSerialize
    data class DeployRequest(
        val ref: String = "master",
        val auto_merge: Boolean = false,
        val payload: String,
        val description: String
    )
}