package ejercicios_integradores.agencia_turismo.repository;

import ejercicios_integradores.agencia_turismo.domain.Localizador;

public class LocalizadorRepository extends GenericRepository<Localizador,Integer>{
    @Override
    public Localizador buscarPorId(Integer id){
        return this.obtenerTodos().stream().filter(l->l.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void crear(Localizador obj) {
        this.obtenerTodos().add(obj);
    }
}
