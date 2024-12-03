public class RepositorioLocalizadores extends Repositorio<Localizador>{

    @Override
    public Localizador buscarPorId(Integer id) {
        return this.getAll().stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }
    public 
}
