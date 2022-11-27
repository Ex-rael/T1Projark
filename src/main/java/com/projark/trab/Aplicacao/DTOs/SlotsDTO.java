package com.projark.trab.Aplicacao.DTOs;

import java.util.Arrays;

public class SlotsDTO {
    private int duracaoEmMinutos;
    private int[] altitudes;

    public SlotsDTO(int duracaoEmMinutos, int[] altitudes) {
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.altitudes = altitudes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int[] getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(int[] altitudes) {
        this.altitudes = altitudes;
    }

    @Override
    public String toString() {
        return "Slots [duracaoEmMinutos=" + duracaoEmMinutos + ", altitudes=" + Arrays.toString(altitudes) + "]";
    }
}
