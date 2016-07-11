
package com.example.dangineering.myapplication.network.responsemodel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class UserListResponse {

    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("members")
    @Expose
    private List<Member> members = new ArrayList<Member>();
    @SerializedName("cache_ts")
    @Expose
    private Integer cacheTs;

    /**
     * 
     * @return
     *     The ok
     */
    public Boolean getOk() {
        return ok;
    }

    /**
     * 
     * @param ok
     *     The ok
     */
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    /**
     * 
     * @return
     *     The members
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * 
     * @param members
     *     The members
     */
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    /**
     * 
     * @return
     *     The cacheTs
     */
    public Integer getCacheTs() {
        return cacheTs;
    }

    /**
     * 
     * @param cacheTs
     *     The cache_ts
     */
    public void setCacheTs(Integer cacheTs) {
        this.cacheTs = cacheTs;
    }

}
