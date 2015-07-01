import ratpack.guice.Guice;
import ratpack.jackson.Jackson;
import ratpack.jackson.JacksonModule;
import ratpack.server.RatpackServer;

/**
 * Created by daniel.hyun on 7/1/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        RatpackServer.start(server -> server
            .registry(Guice.registry(r -> r.module(JacksonModule.class)))
            .handlers(chain -> chain
                .get(ctx -> {
                    Person person = new Person();
                    person.name = "Matt";
                    person.age = 18;
                    ctx.render(Jackson.json(person));
                })
                .post("person", ctx -> {
                    Person p = ctx.parse(Jackson.fromJson(Person.class));
                    ctx.render("You sent " + p.name + " who is " + p.age + " years old");
                })
            ));
    }
}
