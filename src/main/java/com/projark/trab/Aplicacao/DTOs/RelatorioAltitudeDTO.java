package com.projark.trab.Aplicacao.DTOs;

public class RelatorioAltitudeDTO {
    private int altitude;
    private double percentual;

    public RelatorioAltitudeDTO(int altitude, double percentual) {
        this.altitude = altitude;
        this.percentual = percentual;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public String toString() {
        return "RelatorioAltitudeDTO{" +
                "altitude=" + altitude +
                ", percentual=" + percentual +
                '}';
    }
}
