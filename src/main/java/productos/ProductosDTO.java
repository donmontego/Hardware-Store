package productos;

public class ProductosDTO {

    private int codigo_producto;
    private double iva_compra, precio_compra, precio_venta;
    private String nit_proveedor, nombre_producto;

    public ProductosDTO() {

    }

    public ProductosDTO(int codigo_producto, double iva_compra, double precio_compra, double precio_venta,
                        String nit_proveedor, String nombre_producto) {
        this.codigo_producto = codigo_producto;
        this.iva_compra = iva_compra;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.nit_proveedor = nit_proveedor;
        this.nombre_producto = nombre_producto;
    }


    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public double getIva_compra() {
        return iva_compra;
    }

    public void setIva_compra(double iva_compra) {
        this.iva_compra = iva_compra;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(String nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
}

