package br.com.letscode.pedidoapp.config;

import br.com.letscode.pedidoapp.repository.PedidoRepository;
import br.com.letscode.pedidoapp.service.EmailService;
import br.com.letscode.pedidoapp.service.PedidoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public EmailService emailService() {
        return new EmailService("123", "321");
    }
    //    Usa-se o @Bean pra adicionar configurações; Quando é só fácil assim como o de cima, pode só botar @Component na classe;
    //    O PedidoRepository foi anotado com @Repository (variação do @Component), dai conseguimos construir o @Bean abaixo.


//    @Bean
//    public PedidoService pedidoService(PedidoRepository pedidoRepository, EmailService emailService) {
//        return new PedidoService(pedidoRepository, emailService);
//    }
//    Podemos substituir o PedidoService aqui só botando 2Service nele, porque ambas injeções dele ele já sabe fazer, com o @Bean e @Repository;
}
