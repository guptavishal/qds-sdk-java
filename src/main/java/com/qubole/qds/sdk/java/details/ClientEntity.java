package com.qubole.qds.sdk.java.details;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class ClientEntity
{
    private final Object entity;
    private final Method method;
    private final Map<String, String> queryParams;

    public enum Method
    {
        GET,
        POST,
        PUT,
        DELETE
    }

    public ClientEntity(Object entity)
    {
        this(entity, Method.POST, null);
    }

    public ClientEntity(Object entity, Method method)
    {
        this(entity, method, null);
    }

    public ClientEntity(Object entity, Method method, Map<String, String> queryParams)
    {
        this.entity = entity;
        this.method = method;
        this.queryParams = (queryParams != null) ? ImmutableMap.copyOf(queryParams) : null;
    }

    public Object getEntity()
    {
        return entity;
    }

    public Method getMethod()
    {
        return method;
    }

    public Map<String, String> getQueryParams()
    {
        return queryParams;
    }
}
