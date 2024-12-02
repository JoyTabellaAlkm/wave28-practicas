
public class Basico {
        ConsultaSaldos consultaSaldos;
        PagoServicio pagoServicio;
        Depositar depositar;

        public Basico() {
            this.consultaSaldos = new ConsultaSaldos();
            this.pagoServicio = new PagoServicio();
            this.depositar = new Depositar();
        }

        public void getConsultaSaldos() {
            consultaSaldos.transaccionOk();
        }
        public void getPagoServicio() {
            pagoServicio.transaccionNoOk();
        }
        public void getDepositar() {
            depositar.transaccionNoOk();
        }
    }

