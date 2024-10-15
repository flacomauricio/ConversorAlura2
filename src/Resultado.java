public class Resultado implements Comparable<Resultado> {
    private double respuestaConsulta;

    public Resultado(ConsultaAPI consulta) {
        this.respuestaConsulta = consulta.conversionResult();
    }

    public Resultado() {
    }

    public Double getRespuestaConsulta() {
        return respuestaConsulta;
    }

    @Override
    public int compareTo(Resultado o) {
        return this.getRespuestaConsulta().compareTo(o.getRespuestaConsulta());
    }
}
