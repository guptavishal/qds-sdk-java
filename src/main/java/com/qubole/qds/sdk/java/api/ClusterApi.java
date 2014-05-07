package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.client.QdsClient;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/cluster-api/
 */
public interface ClusterApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/list-clusters/
     *
     * @return new builder
     */
    public ClusterListBuilder list();

    /**
     * Corresponds to http://www.qubole.com/docs/get-cluster-state/
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterStateBuilder state(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/get-cluster-information/
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterInformationBuilder information(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/start-terminate-cluster/ for "start"
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterStartBuilder start(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/start-terminate-cluster/ for "terminate"
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public ClusterTerminateBuilder terminate(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/edit-cluster/
     *
     * @param labelOrId the Cluster label/id
     * @param configBuilder config values - use {@link QdsClient#clusterConfig()}
     * @return new builder
     */
    public ClusterEditBuilder edit(String labelOrId, ClusterConfigBuilder configBuilder);
}
