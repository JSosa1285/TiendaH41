import java.util.List;
import java.util.ArrayList;

public class Almacen
{
    private List<Producto> listaProductos;
    private ArchivoProductos a;
    
    public Almacen()
    {
        a = new ArchivoProductos();
        this.listaProductos = a.leerArchivo();
    }
    
    public List<Producto> getListaProductos()
    {
        return this.listaProductos;
    }
    
    public int getSiguienteCodigo()
    {
        int size = this.listaProductos.size();
        if (size > 0)
        {
            return this.listaProductos.get(size -1).getCodigo() + 1;
        }
        else
        {
            return 1;
        }
        
    }
    
    public void agregarProdcuto(Producto p)
    {
        this.listaProductos.add(p);
        a.guardarProducto(p.toCSV());
    }
    
    public int buscarIndiceProducto(int codigo)
    {
        for (int i = 0; i < this.listaProductos.size(); i++)
        {
            if (this.listaProductos.get(i).getCodigo() == codigo)
            {
                 return i;
            }
        }
        return -1;
    }
    
    public Producto buscarProducto(int codigo)
    {
        for (Producto p: this.listaProductos)
        {
            if (p.getCodigo() == codigo)
            {
                 return p;
            }
        }
        return null;
    }
    
    public ArrayList<Producto> buscarProductos(String criterio)
    {
        ArrayList<Producto> listaResultado = new ArrayList<Producto>();
        for (Producto p: this.listaProductos)
        {
            if (p.getNombre().equals(criterio) || p.getMarca().equals(criterio) || p.getPresentacion().equals(criterio) || p.getTipo().equals(criterio))
            {
                listaResultado.add(p);
            }
                    }
        return listaResultado;
    }
    
    public void eliminarProdcuto(int codigo)
    {
        int indiceABorrar = this.buscarIndiceProducto(codigo);
        if (indiceABorrar != -1)
        {
            this.listaProductos.remove(indiceABorrar);
        }
        
        /*Producto productoABorrar = this.buscarProducto(codigo);
        if (productoABorrar != null)
        {
            this.listaProductos.remove(productoABorrar);
        }
        */
    }
    
    public void aumentarCantProdcuto(int codigo, int cant)
    {
        int indiceAAumentarCantidad = this.buscarIndiceProducto(codigo);
        if (indiceAAumentarCantidad != -1)
        {
            int nuevaCantidad = this.listaProductos.get(indiceAAumentarCantidad).getCantidad() + cant;
            this.listaProductos.get(indiceAAumentarCantidad).setCantidad(nuevaCantidad);
        }
        
    }
    
    public void disminuirCantProdcuto(int codigo, int cant)
    {
        int indiceADisminuirCantidad = this.buscarIndiceProducto(codigo);
        if (indiceADisminuirCantidad != -1)
        {
            int nuevaCantidad = this.listaProductos.get(indiceADisminuirCantidad).getCantidad() - cant;
            if (nuevaCantidad >= 0)
            {
                this.listaProductos.get(indiceADisminuirCantidad).setCantidad(nuevaCantidad);
            }
        }
    }
    
    public void modificarPrecio(int codigo, int precio)
    {
        int indiceAModificarCantidad = this.buscarIndiceProducto(codigo);
        if (indiceAModificarCantidad != -1)
        {
            this.listaProductos.get(indiceAModificarCantidad).setPrecio(precio);
        }
    }
    

    

    
    
    
    


}
