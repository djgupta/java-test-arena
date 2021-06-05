package test.tester;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ExchangeConfig {
	
	private String isoSegment;
    private String isoOperating;
    private String morningstarCode;
    private String exchangeCountryIso2;
    private String exchangeCountryIso3;
    private Map<String, Boolean> universeExchangeEligibility = new HashMap<>();
    private LocalDateTime effectiveTimestamp;
    private LocalDateTime systemTimestamp;
    private boolean isDeleted;

    public ExchangeConfig() {
    }

    public ExchangeConfig(String isoSegment, String isoOperating, String morningstarCode, String exchangeCountryIso2, String exchangeCountryIso3, Map<String, Boolean> universeExchangeEligibility, LocalDateTime effectiveTimestamp, LocalDateTime systemTimestamp) {
        this.isoSegment = isoSegment;
        this.isoOperating = isoOperating;
        this.morningstarCode = morningstarCode;
        this.exchangeCountryIso2 = exchangeCountryIso2;
        this.exchangeCountryIso3 = exchangeCountryIso3;
        this.universeExchangeEligibility = universeExchangeEligibility;
        this.effectiveTimestamp = effectiveTimestamp;
        this.systemTimestamp = systemTimestamp;
    }
    


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isoSegment);
		builder.append(",");
		builder.append(isoOperating);
		builder.append(",");
		builder.append(morningstarCode);
		builder.append(",");
		builder.append(exchangeCountryIso2);
		builder.append(",");
		builder.append(exchangeCountryIso3);
		builder.append(",");
		builder.append(universeExchangeEligibility);
		builder.append(",");
		builder.append(effectiveTimestamp);
		builder.append(",");
		builder.append(systemTimestamp);
		builder.append(",");
		builder.append(isDeleted);
		return builder.toString();
	}
	
	public String toString(String universe) {
		StringBuilder builder = new StringBuilder();
		builder.append(isoSegment);
		builder.append(",");
		builder.append(isoOperating);
		builder.append(",");
		builder.append(morningstarCode);
		builder.append(",");
		builder.append(exchangeCountryIso2);
		builder.append(",");
		builder.append(exchangeCountryIso3);
		builder.append(",");
		builder.append(universeExchangeEligibility.get(universe));
		builder.append(",");
		builder.append(effectiveTimestamp);
		builder.append(",");
		builder.append(systemTimestamp);
		builder.append(",");
		builder.append(isDeleted);
		return builder.toString();
	}

	public String getIsoSegment() {
        return isoSegment;
    }

    public void setIsoSegment(String isoSegment) {
        this.isoSegment = isoSegment;
    }

    public String getIsoOperating() {
        return isoOperating;
    }

    public void setIsoOperating(String isoOperating) {
        this.isoOperating = isoOperating;
    }

    public String getMorningstarCode() {
        return morningstarCode;
    }

    public void setMorningstarCode(String morningstarCode) {
        this.morningstarCode = morningstarCode;
    }

    public String getExchangeCountryIso2() {
        return exchangeCountryIso2;
    }

    public void setExchangeCountryIso2(String exchangeCountryIso2) {
        this.exchangeCountryIso2 = exchangeCountryIso2;
    }

    public String getExchangeCountryIso3() {
        return exchangeCountryIso3;
    }

    public void setExchangeCountryIso3(String exchangeCountryIso3) {
        this.exchangeCountryIso3 = exchangeCountryIso3;
    }

    public Map<String, Boolean> getUniverseExchangeEligibility() {
        return universeExchangeEligibility;
    }

    public void setUniverseExchangeEligibility(Map<String, Boolean> universeExchangeEligibility) {
        this.universeExchangeEligibility = universeExchangeEligibility;
    }

    public LocalDateTime getEffectiveTimestamp() {
        return effectiveTimestamp;
    }

    public void setEffectiveTimestamp(LocalDateTime effectiveTimestamp) {
        this.effectiveTimestamp = effectiveTimestamp;
    }

    public LocalDateTime getSystemTimestamp() {
        return systemTimestamp;
    }

    public void setSystemTimestamp(LocalDateTime systemTimestamp) {
        this.systemTimestamp = systemTimestamp;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
}
