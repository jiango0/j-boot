package com.jzc.spring.generate.model;

import java.util.Date;
import java.util.List;

public class GetawayModel {

    private String id;

    private Date createTime;

    private Date modifyTime;

    private GroupModel group;

    private String apiName;

    private String path;

    private String oldPath;

    private String routeType;

    private String httpMethod;

    private String mediaType;

    private int timeout;

    private Boolean retryable;

    private String requestContent;

    private String responseContent;

    private String responseType;

    private String status;

    private String reason;

    private String createUser;

    private String remark;

    private Boolean cacheable;

    private int cachetime;

    private Boolean authorized;

    private List<RouteModel> routes;

    private List<RequestParamModel> requestParams;

    private List<ResponseParamModel> responseParams;

    private List<ValidateParamModel> validateParams;

    private Boolean enable;

    private Boolean _new;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public GroupModel getGroup() {
        return group;
    }

    public void setGroup(GroupModel group) {
        this.group = group;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOldPath() {
        return oldPath;
    }

    public void setOldPath(String oldPath) {
        this.oldPath = oldPath;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Boolean getRetryable() {
        return retryable;
    }

    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getCacheable() {
        return cacheable;
    }

    public void setCacheable(Boolean cacheable) {
        this.cacheable = cacheable;
    }

    public int getCachetime() {
        return cachetime;
    }

    public void setCachetime(int cachetime) {
        this.cachetime = cachetime;
    }

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public List<RouteModel> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteModel> routes) {
        this.routes = routes;
    }

    public List<RequestParamModel> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(List<RequestParamModel> requestParams) {
        this.requestParams = requestParams;
    }

    public List<ResponseParamModel> getResponseParams() {
        return responseParams;
    }

    public void setResponseParams(List<ResponseParamModel> responseParams) {
        this.responseParams = responseParams;
    }

    public List<ValidateParamModel> getValidateParams() {
        return validateParams;
    }

    public void setValidateParams(List<ValidateParamModel> validateParams) {
        this.validateParams = validateParams;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean get_new() {
        return _new;
    }

    public void set_new(Boolean _new) {
        this._new = _new;
    }
}
