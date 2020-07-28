package jp.co.valus.lambda_benchmark

import org.eclipse.egit.github.core.client.GitHubClient
import org.slf4j.LoggerFactory


class GithubActionsDeployService(githubAccessToken: String) {

    companion object {
        private const val GITHUB_URI_DEPLOYMENT = "repos/nabesuke0/lambda_benchmark_k_j/deployments"
        private val LOG = LoggerFactory.getLogger(this::class.java)
    }

    private val githubClient = GitHubClient().apply {
        setOAuth2Token(githubAccessToken)
    }

    fun deployLambda(environment: String) {
        LOG.info("deployLambda : $environment")

        try {
            githubClient.post<DeployRequest>(
                GITHUB_URI_DEPLOYMENT,
                DeployRequest(
                    payload = mapOf(
                        "deploy_type" to "ps2-lambda",
                        "environment" to environment
                    ),
                    description = "deployment : $environment"
                ),
                DeployRequest::class.java
            )
        } catch (e: Exception) {
            LOG.info("deploy failure", e)
        }
    }

    data class DeployRequest(
        val ref: String = "master",
        val auto_merge: Boolean = false,
        val payload: Map<String, String>,
        val description: String
    )
}