import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteExcecaoBaseInvalida.class, testeParametrizado.class, TesteContribuinte.class, TesteCalculosIRPF.class })
public class AllTests {

}
