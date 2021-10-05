package ventas;

public class DetalleVentaDTO {
    private int codigoDetalleVenta;
    private int cantidadProduto;
    private int codigoProduto;
    private int codigoVenta;
    private double valorTotal;
    private double valorVenta;
    private double valorIva;

    public DetalleVentaDTO(int cantidadProduto, int codigoProduto, int codigoVenta, int valorTotal, int valorVenta, int valorIva) {
        this.cantidadProduto = cantidadProduto;
        this.codigoProduto = codigoProduto;
        this.codigoVenta = codigoVenta;
        this.valorTotal = valorTotal;
        this.valorVenta = valorVenta;
        this.valorIva = valorIva;
    }

    public DetalleVentaDTO() {
    }

    public DetalleVentaDTO(int cantidadProduto, int codigoProduto) {
        this.cantidadProduto = cantidadProduto;
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(int codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public int getCantidadProduto() {
        return cantidadProduto;
    }

    public void setCantidadProduto(int cantidadProduto) {
        this.cantidadProduto = cantidadProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }
}
