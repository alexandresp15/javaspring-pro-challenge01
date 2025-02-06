# DESAFIO Componentes e injeção de dependência

Meu primeiro desafio do curso DevSuperior (Java Spring Professional)

Neste desafio foi possivel conhecer na pática como funciona a Inversão de Controle (IoC) e Injeção de Dependência (DI), percebi que esses dois conceitos são fundamentais no desenvolvimento de software, especialmente em aplicações Java que utilizam frameworks como Spring.
Abaixo explicarei cada um deles:

## 1. Inversão de Controle (IoC – Inversion of Control)

Inversão de Controle é um princípio de design onde a responsabilidade de criar e gerenciar dependências de um objeto é transferida para um container ou framework, em vez de ser feita manualmente pelo próprio código.

#### **Exemplo sem IoC:**
```java
public class Service {
    private Repository repository;

    public Service() {
        this.repository = new Repository(); // O próprio Service cria sua dependência
    }
}
```
**🔴 Problema:** O `Service` está fortemente acoplado ao `Repository`, dificultando a manutenção e os testes.

#### **Exemplo com IoC (utilizando Injeção de Dependência):**
```java
public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository; // Dependência injetada externamente
    }
}
```
✅ **Benefício:** Agora, `Service` não precisa saber como criar um `Repository`, ele apenas recebe um pronto.

## 2. Injeção de Dependência (DI – Dependency Injection)

Injeção de Dependência é uma maneira de implementar a Inversão de Controle. Ela permite que as dependências sejam passadas para um objeto em vez de ele mesmo criá-las.

#### **Formas principais de DI:**

### **1. Injeção via Construtor**
- A dependência é passada como argumento do construtor.
- Preferida quando a dependência é obrigatória.

```java
public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
}
```

### **2. Injeção via Setter**
- A dependência é passada por meio de um método `set()`.
- Últil quando a dependência pode ser opcional.

```java
public class Service {
    private Repository repository;

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
```

### **3. Injeção via Interface (menos comum)**
- O próprio objeto recebe a dependência através de um método definido em uma interface.

```java
public interface Injectable {
    void inject(Repository repository);
}

public class Service implements Injectable {
    private Repository repository;

    @Override
    public void inject(Repository repository) {
        this.repository = repository;
    }
}
```

---

## 3. IoC e DI no Spring Framework

O **Spring** gerencia as dependências automaticamente usando o contêiner de IoC. Basta anotar as classes com `@Component`, `@Service`, `@Repository`, e o Spring cuidará da injeção de dependência.

### **Exemplo usando Spring:**
```java
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MyService {
    private final MyRepository repository;

    @Autowired  // O Spring injeta a dependência automaticamente
    public MyService(MyRepository repository) {
        this.repository = repository;
    }
}
```

---

## **Benefícios do IoC e DI**
✅ Código mais modular e testável.  
✅ Redução do acoplamento entre classes.  
✅ Facilidade de manutenção e escalabilidade.  
