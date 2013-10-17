package edu.upc.eetac.dsa.rodrigo.sampedro.clasesesencialesi.clases;

public  class BigNumberException extends Exception {
    public BigNumberException(int num) {
        super("Error to parse INT. El Numero "+num+"es Superior a 1000");
    }
}