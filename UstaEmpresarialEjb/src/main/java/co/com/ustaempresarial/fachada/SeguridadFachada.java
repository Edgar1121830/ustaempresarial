package co.com.ustaempresarial.fachada;

import java.util.List;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.Rol;
import co.com.ustaempresarial.seguridad.modelo.Usuario;
import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;

public interface SeguridadFachada {
	
	
	/**
	 * metodo para listar los usuarios
	 * @return List<CategoriaProducto>: listado de productos
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<Usuario> traerUsuarios() throws Exception;
	
	/**
	 * metodo que crea los usuarios 
	 * @param User: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 */
	public void crearUsuario(Usuario user) throws Exception;
	
	/**
	 * metodo encargado de actualizar los usuarios 
	 * @param Usuario
	 * @return el usuario que se creo
	 * @throws Exception
	 */
	public Usuario editarUsuario(Usuario user) throws Exception;
	
	/**
	 * metodo que borra el Usuario seleccionado
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 */
	public boolean borrarUsuario(int codigo) throws Exception;

	/**
	 * metodo que busca por el nombre de Usuario
	 * @param nombre: nombre de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 */
	public List<Usuario> buscarUsuarioPorNombre(String nombre) throws Exception;
	//************************Usuario_Log*********************************************
			/**
	 * metodo para listar los usuarios_log
	 * @return List<UsuarioLog>: listado de usuarioLog
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Lorena
	 */
		public List<UsuarioLog> listarUsuarioLog() throws Exception;

	/**
	 * metodo que crea los usuarios_log 
	 * @param usuarioLog: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 *  @author Lorena
	 */
		public void crearUsuarioLog(UsuarioLog usuarioLog) throws Exception;

	/**
	 * metodo encargado de actualizar los usuarios_log 
	 * @param usuarioLog
	 * @return el usuarioLog que se ha creado
	 * @throws Exception
	 * @author Lorena
	 */
		public UsuarioLog editarUsuarioLog(UsuarioLog usuarioLog) throws Exception;

	/**
	 * metodo que borra el usuarioLog seleccionado
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 * @author Lorena
	 */
		public boolean eliminarUsuarioLog(int codigo) throws Exception;
	/**
	 * metodo que busca por el codigo de UsuarioLog
	 * @param codigo: codigo de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Lorena
	 */
	
		public UsuarioLog buscarUsuarioLog(int codigo) throws Exception; 
		/**
	 * metodo que busca por el proceso de UsuarioLog
	 * @param proceso: proceso de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Lorena
	 */
public List<UsuarioLog> buscarUsuarioLogPorProceso(String proceso) throws Exception; 
	//********************************************************************************
		//--------------rol-----------------------------------------------------------
		/**
		 * metodo para listar los roles
		 * @return List<Rol>: listado de rol
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Jairo
		 */
			public List<Rol> listarRol() throws Exception;
		
		/**
		 * metodo que crea los roles
		 * @param rol: tipo de objeto a crear
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Jairo
		 */
			public void crearRol(Rol rol) throws Exception;
		
		/**
		 * metodo encargado de actualizar los roles 
		 * @param rol
		 * @return el rol que se ha actualizado
		 * @throws Exception
		 * @author Jairo
		 */
			public Rol editarRol(Rol rol) throws Exception;

		/**
		 * metodo que borra el rol seleccionado
		 * @param codigo
		 * @return true: donde si borra y false donde hay error de ejecucion
		 * @throws Exception
		 * @author Jairo
		 */
			public boolean eliminarRol(int codigo) throws Exception;
		/**
		 * metodo que busca por el codigo de rol
		 * @param codigo: codigo de usuario
		 * @return: la objeto Usuario
		 * @throws Exception
		 * @author Jairo
		 */
			public Rol buscarRol(int codigo) throws Exception; 
		/**
		 * metodo que busca por el nombre de rol
		 * @param nombre: nombre de usuario
		 * @return: la objeto Usuario
		 * @throws Exception
		 * @author Jairo
		
		*/
	public List<Rol> buscarRolPorNombre(String nombre) throws Exception;
	
	//******************************Permiso*******************************************
	/**
	 * metodo para listar los roles
	 * @return List<Permiso>: listado de Permiso
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Lizeth
	 */
		public List<Permiso> listarPermiso() throws Exception;
	
	/**
	 * metodo que crea los permiso
	 * @param permiso: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lizeth
	 */
		public void crearPermiso(Permiso permiso) throws Exception;
		/**
		 * metodo para editar permisos
		 * @param permiso: tipo de objeto a editar
		 * @return permiso tipo de objeto que se edita
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */

		public Permiso editarPermiso(Permiso permiso) throws Exception;
		/**
		 * metodo para eliminar permisos
		 * @param codigo identificador para buscar el objeto a borrar
		 * @return boolean tipo de respuesta para la eliminacion de objeto permiso
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */
		public boolean eliminarPermiso(int codigo) throws Exception;
		/**
		 * metodo para bucar permisos con codigo
		 * @param permiso: tipo de objeto buscar 
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */
		
		public Permiso buscarPermiso(int codigo) throws Exception; 
		/**
		 * metodo para bucar permisos por nombre
		 * @param permiso: tipo de objeto buscar 
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */
		
		public List<Permiso> buscarPermisoPorNombre(String nombre) throws Exception;
	
       //********************************rol_usuario*******************************************
		/**
		 * metodo para listar los RolUsuarios
		 * @return List<RolUsuario>: listado de RolUsuario
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 *@author Favian
		 */
		public List<RolUsuario> listarRolUsuario() throws Exception;
		/**
		 * metodo encargado para crear rolUsuario 
		 * @return el Rolusuario que se creo
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Favian
		 */
		public void crearRolUsuario(RolUsuario rolU) throws Exception;
		/**
		 * metodo encargado de buscar los RolUsuarios 
		 * @param codigo del usuario
		 * @return el objeto rolUsuario
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 *@author Favian
		 */
		public RolUsuario buscarRolUsuario(int codigo) throws Exception; 
		
	//**********************************rol_permiso******************************************
		/**
		 * metodo para listar los RolPermiso
		 * @return List<RolPermiso>: listado de RolPermiso
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Favian
		 */
		public List<RolPermiso> listarRolPermiso() throws Exception;
		/**
		 * metodo encargado para crear el rolPermiso
		 * @throws Exception
		 * @author Favian
		 */
		public void crearRolPermiso(RolPermiso rolP) throws Exception;
		/**
		 * metodo para listar los RolPermiso
		 * @param codigo del permiso
		 * @return el objeto rolPermiso
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Favian
		 */
		public RolPermiso buscarRolPermiso(int codigo) throws Exception;
	
}
