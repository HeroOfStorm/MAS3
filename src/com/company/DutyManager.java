package com.company;

import org.jetbrains.annotations.NotNull;
/**
 * @author Serhii Krasnoiarskyi s18943
 *
 */
public class DutyManager {
    private Responsibility responsibility;

    private final String region;

    public DutyManager(@NotNull Responsibility responsibility, @NotNull String region) throws Exception{
        if (responsibility.getDutyExpectantResponsibility() != null || responsibility.getDutyManagerResponsibility() != null) {
            throw new Exception("Responsibility already defined");
        }

        this.region = region;
        setResponsibility(responsibility);
        responsibility.addDutyManagerResponsibility(this);
    }

    public void createRapport(){
        System.out.println(region + "reporting for duty");
    }

    public String getRegion() {
        return region;
    }

    private void setResponsibility(@NotNull Responsibility responsibility) {
        this.responsibility = responsibility;
    }
}
