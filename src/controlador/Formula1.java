/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.CampeonatoMundial;
import entidades.Circuito;
import entidades.Escuderia;
import entidades.GranPremio;
import entidades.Piloto;
import entidades.Posicion;
import java.util.ArrayList;
import java.util.List;
import registros.RegistroClasificaciones;
import registros.RegistroEscuderias;
import registros.RegistroCircuitos;
import registros.RegistroPilotos;
import registros.RegistroCampeonatoMundial;
import registros.RegistroGranPremio;
/**
 *
 * @author MAMISHO
 */
public class Formula1 {
    //Campeonato mundial
    CampeonatoMundial campeonatoMundial;
    //Registros
    RegistroClasificaciones registroClasificaciones;
    RegistroEscuderias registroDatosEscuderias;
    RegistroCircuitos registroDatosCircuitos;
    RegistroPilotos registroDatosPilotos;
    RegistroCampeonatoMundial registroDatosCampeonatoMundial;
    RegistroGranPremio registroDatosGranPremio;
    //entidades
    Escuderia escuderia;
    Piloto piloto;
    Posicion posicion;
    Circuito circuito;
    GranPremio granPremio;
    
    public Formula1(){
        //creamos los registros y la carga de datos se hace
        //en el main
        registroClasificaciones=new RegistroClasificaciones();
        registroDatosEscuderias=new RegistroEscuderias();
        registroDatosPilotos=new RegistroPilotos();
        registroDatosCampeonatoMundial=new RegistroCampeonatoMundial(); 
        registroDatosGranPremio=new RegistroGranPremio();
        //this.inicalizaCM();
    }
    
    public void inicializaCM(){
       this.campeonatoMundial=new CampeonatoMundial();
    }
    
    public void introducirDatosCM(String anyo,double numeroGP,ArrayList<GranPremio>grandesPremios){
    this.campeonatoMundial.introducirDatosCM(anyo, numeroGP,grandesPremios);
    this.registroDatosCampeonatoMundial.guardarCampeonatoMundial(campeonatoMundial);
    }
    
     public void cargarDatosCM(){
        this.registroDatosCampeonatoMundial.cargarCampeonatos();
    }
    
    //Grandes Premios
    
    public void inicializaGP(){
       this.granPremio=new GranPremio();
    }
    
    public void introducirDatosGP(String nombre, String pais,Circuito circuito, String dia,
            String mes, String anyo){
    this.granPremio.introducirDatosGP(nombre,pais,circuito,dia,mes,anyo);
    this.registroDatosGranPremio.guardarGranPremio(granPremio);
    }
    
     public void cargarDatosGrandesPremios(){
        this.registroDatosGranPremio.cargarGrandesPremios();
    }
    
    //piloto
    public void realizarAltaPiloto(){
        this.piloto=new Piloto();
    }
    public void realizarBajaPiloto(String idPiloto){
        this.piloto=this.registroDatosPilotos.introduceIdPiloto(idPiloto);
        this.registroDatosPilotos.borraPiloto(piloto);
    }
    public void realizarConsultaPiloto(String idPiloto){
        this.piloto=this.registroDatosPilotos.introduceIdPiloto(idPiloto);
        this.piloto.mostrarDatos(piloto);
    }
    public void realizarModificarPiloto(String idPiloto){
        this.piloto=this.registroDatosPilotos.introduceIdPiloto(idPiloto);
        this.piloto.mostrarDatos(piloto);
    }
    
    public void introducirDatosPiloto(String nombre,String apellido,String idPiloto,String equipo,
    String equipoAnterior,String nacionalidad, String fechaNacimiento){
    this.piloto.introducirDatos(nombre,apellido,idPiloto,equipo,equipoAnterior,nacionalidad,fechaNacimiento);
    this.registroDatosPilotos.guardarPiloto(this.piloto);
    }
    
    public void modificarDatosPiloto(String nombre,String apellido,String idPiloto,String equipo,
    String equipoAnterior,String nacionalidad, String fechaNacimiento){
    this.piloto.introducirDatos(nombre,apellido,idPiloto,equipo,equipoAnterior,nacionalidad,fechaNacimiento);
    this.registroDatosPilotos.guardarPilotoModificado(piloto);
    }
    
    public void cambiarEquipoPiloto(String idPiloto,String idEscuderia){
    this.piloto=this.registroDatosPilotos.introduceIdPiloto(idPiloto);
    this.escuderia=this.registroDatosEscuderias.introduceIdEscuderia(idEscuderia);
    this.piloto.setEquipoAnterior(this.piloto.getEquipo());
    this.piloto.setEquipo(this.escuderia.getNombre());
    registroDatosPilotos.guardarPilotoModificado(this.piloto);
    //Faltan los cambios realizados sobre la escuderia, es decir borrar el piloto de la escuderia
    }
    
    public void cargarDatosPilotos(){
        this.registroDatosPilotos.cargarPilotos();
    }
    
    //Escuderia
    public void realizarAltaEscuderia(){
        this.escuderia=new Escuderia();
    }
    
    /*Nota de la implementación
     @overwrite
     * Si implementaramos los escenarios alternativos
     * tendriamos que comprobar si el id existe en la
     * lista, como solo nos centramos en el caso normal
     * no comprobamos y solicitamos la escuderia
     */
    public void realizarBajaEscuderia(String idEscuderia){
        this.escuderia=this.registroDatosEscuderias.introduceIdEscuderia(idEscuderia);
        this.registroDatosEscuderias.borraEscuderia(escuderia);
    }
    
    public void realizarConsultaEscuderia(String idEscuderia){
        this.escuderia=this.registroDatosEscuderias.introduceIdEscuderia(idEscuderia);
        this.escuderia.mostrarDatos(escuderia);
    }
    
    public void realizarModificarEscuderia(String idEscuderia){
        this.escuderia=this.registroDatosEscuderias.introduceIdEscuderia(idEscuderia);
        this.escuderia.mostrarDatos(escuderia);
        
    }
    
    public void introducirDatosEscuderia(String[] pilotos,String[] pilotosActivos,String nombre,String sede,String chasis,String motor,String neumaticos,String primeraTemporada,String fechaCrea){
        //construimos los datos de La escuderia y se la enviamos
        List<Piloto> listaPilotos=new ArrayList<Piloto>();
        List<String> listaPilotosActivos=new ArrayList<String>();
        int i=0;
        //creo la lista de pilotos
        for(i=0;i<pilotos.length;i++){
            Piloto p=new Piloto(pilotos[i]);
            listaPilotos.add(p);
        }
        
        //creo la lista de idPilotosActivos
        for(i=0;i<pilotosActivos.length;i++){
            listaPilotosActivos.add(pilotosActivos[i]);
        }
        
        //introducimos los datos en la escuderia
        this.escuderia.introducirDatos(listaPilotos, listaPilotosActivos, nombre, sede, chasis, motor, neumaticos, primeraTemporada, fechaCrea);
        
        //guarda la escuderia
        registroDatosEscuderias.guardarEscuderia(this.escuderia);
    }
    
    public void modificarDatosEscuderia(/*String nombre,*/String sede,String chasis,String motor,String neumaticos,String primeraTemporada,String fechaCrea){
        this.escuderia.modificarDatos(/*nombre,*/sede, chasis, motor, neumaticos, primeraTemporada, fechaCrea);
        this.registroDatosEscuderias.guardarEscuderiaModificada(escuderia);
    }
   
    public void realizarCambioPilotosActivos(String idEscuderia){
        //se sincronizara cuando este implementado el registro de pilotos
        //porque es necesario para el funcionamiento.
        System.out.println("inicia el cambio");
    }
    
    //circuitos
    
    public void realizarAltaCircuito(){
        this.circuito=new Circuito();
        
    }
    public void realizarBajaCircuito(String idcircuito){
        this.circuito=this.registroDatosCircuitos.introduceIdcircuito(idcircuito);
        this.registroDatosCircuitos.borraCircuito(circuito);
    }
    public void realizarConsultaCircuito(String idcircuito){
        this.circuito=this.registroDatosCircuitos.introduceIdcircuito(idcircuito);
        this.circuito.muestradatos(circuito);
        
    }
    public void realizarModificarCircuito(String idcircuito){
        this.circuito=this.registroDatosCircuitos.introduceIdcircuito(idcircuito);
        this.registroDatosCircuitos.borraCircuito(circuito);
        
    }
    
    public void cargarDatosEscuderias(){
        this.registroDatosEscuderias.cargarEscuderias();
    }
     public Circuito introduceIdCircuito(String idcircuito){
        Circuito cir=this.registroDatosCircuitos.introduceIdcircuito(idcircuito);
        return cir;
    }
    /*metodos de consultas campeonato mundial
     * descomentar despues de implementar metodos 
     * necesarios para funcionamiento(CU-13 y CU-20)
     */
    
    public void consultaCECM(){
        List<Posicion> posiciones=registroClasificaciones.obtenerListaPosicionesCM(this.campeonatoMundial.getAnyo());
        //this.posicion.mostrarClasificacionEscuderiasCM(posiciones);
    }
    
    public void consultaCPCM(){
        List<Posicion> posiciones=registroClasificaciones.obtenerListaPosicionesCM(this.campeonatoMundial.getAnyo());
        //this.posicion.mostrarClasificacionPilotosCM(posiciones);
    }
    //metodos necesarios
    
    public void setCampeonatoMundial(CampeonatoMundial cm){
        this.campeonatoMundial=cm;
    }
    
    public CampeonatoMundial getCampeonatoMundial(){
        return this.campeonatoMundial;
    }
    
}
