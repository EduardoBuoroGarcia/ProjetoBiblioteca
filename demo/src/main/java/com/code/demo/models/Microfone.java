package com.code.demo.models;

public class Microfone {
     public float volume;
     public boolean mutar;
     public String corLed;
    private static int numero;
     public Microfone(String corLed){
         this.corLed = corLed;
     }
     public Microfone(){
     }

    public static void setNumero(int novoNumero) {
        numero = novoNumero;
    }
    public static int getNumero() {
        return numero;
    }
    public void AlterarVolume(float novoVolume){
         this.volume = novoVolume;
        System.out.println("o volume foi alterado" + novoVolume);
    }

    public void BloquearMinhaVoz( boolean mutar){
        this.mutar = mutar;
        System.out.println("Bloquear minha voz recebeu o mutar "+ mutar);
    }

    @Override
    public String toString() {
        return "Microfone{" +
                "volume=" + volume +
                ", mutar=" + mutar +
                ", corLed='" + corLed + '\'' +
                '}';
    }
}
