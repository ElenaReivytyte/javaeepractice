package mybatis.model;

public class Network {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.NETWORK.ID
     *
     * @mbg.generated Sun Apr 28 18:55:23 EEST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.NETWORK.NETWORKNAME
     *
     * @mbg.generated Sun Apr 28 18:55:23 EEST 2019
     */
    private String networkname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.NETWORK.ID
     *
     * @return the value of PUBLIC.NETWORK.ID
     *
     * @mbg.generated Sun Apr 28 18:55:23 EEST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.NETWORK.ID
     *
     * @param id the value for PUBLIC.NETWORK.ID
     *
     * @mbg.generated Sun Apr 28 18:55:23 EEST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.NETWORK.NETWORKNAME
     *
     * @return the value of PUBLIC.NETWORK.NETWORKNAME
     *
     * @mbg.generated Sun Apr 28 18:55:23 EEST 2019
     */
    public String getNetworkname() {
        return networkname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.NETWORK.NETWORKNAME
     *
     * @param networkname the value for PUBLIC.NETWORK.NETWORKNAME
     *
     * @mbg.generated Sun Apr 28 18:55:23 EEST 2019
     */
    public void setNetworkname(String networkname) {
        this.networkname = networkname;
    }
}