package net.sidglobal.provider_network;

/**
 * Created by Bhargav on 24-09-2017.
 */

import java.util.Date;

public class ProviderNetwork {
    private String npi;
    private String tin;
    private String spec;
    private String networkName;
    private Date startDate;
    private Date endDate;
	public String getNpi() {
		return npi;
	}
	public void setNpi(String npi) {
		this.npi = npi;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getNetworkName() {
		return networkName;
	}
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
