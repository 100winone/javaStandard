### π‘Day16 κ°μ²΄μ§ν₯ νλ‘κ·Έλλ° 2 - μΈν°νμ΄μ€(interface)
> μ΄ κΈμ λ¨κΆμ±λμ μλ°μ μ μ 3/eλ₯Ό κΈ°λ°μΌλ‘ κ³΅λΆν λ΄μ©μ μ λ¦¬ν κΈμλλ€.
>
> **μμ€μ λ¦¬**: https://github.com/100winone/javaStandard

### μΈν°νμ΄μ€(interface)
> μ€μ§ μΆμλ©μλμ μμλ§μ λ©€λ²λ‘ κ°μ§ μ μμΌλ©°, κ·Έ μΈμ λ€λ₯Έ μ΄λ ν μμλ νμ©νμ§ μμ

```
μΆμν΄λμ€ vs μΈν°νμ΄μ€ μ°¨μ΄

μΆμν΄λμ€
    - λΆλΆμ μΌλ‘ μμ±λ 'λ―Έμμ± μ€κ³λ'
    - μΌλ° λ©μλ λλ λ©€λ² λ³μλ₯Ό κ°μ§ μ μμ
μΈν°νμ΄μ€
    - κ΅¬νλ κ²μ μλ¬΄ κ²λ μκ³  λ°κ·Έλ¦Όλ§ κ·Έλ €μ§ 'κΈ°λ³Έ μ€κ³λ'
    - μΌλ° λ©μλ λλ λ©€λ²λ³μλ₯Ό κ΅¬μ±μμΌλ‘ κ°μ§ μ μμ
```

```java
inferface μΈν°νμ΄μ€μ΄λ¦ {
    public static final νμ μμμ΄λ¦ = κ°;
    public abstract λ©μλμ΄λ¦(λ§€κ°λ³μλͺ©λ‘);
}
```

#### μΈν°νμ΄μ€ λ©€λ² μ μ½μ¬ν­
- λͺ¨λ  λ©€λ²λ³μλ public static final μ΄μ΄μΌ νλ©°, μ΄λ₯Ό μλ΅ν  μ μλ€.
- λͺ¨λ  λ©μλλ public abstract μ΄μ΄μΌ νλ©°, μ΄λ₯Ό μλ΅ν  μ μλ€.
- λ μ μ΄μλ νΈμμ μλ΅ κ°λ₯νλ€.

```java
inferface PlayingCard {
    public static final int SPADE = 4;
    public int DIAMOND = 3;
    static int HEART = 2;
    int CLOVER = 1;
    
    public abstract String getCardNumber();
    String getCardKind();
}
```

#### μΈν°νμ΄μ€μ μμ
> μΈν°νμ΄μ€λ μΈν°νμ΄μ€λ‘λΆν°λ§ μμλ°μ μ μμΌλ©°, ν΄λμ€μλ λ¬λ¦¬ λ€μ€μμ, μ¦ μ¬λ¬ κ°μ μΈν°νμ΄μ€λ‘λΆν° μμμ λ°λ κ²μ΄ κ°λ₯
```java
interface Movable{
    void move(int x, int y);
}
interface Attackable{
    void attack(Unit u);
}

interface Fightable extends Movable, Attackable{}
```

#### μΈν°νμ΄μ€μ κ΅¬ν
```java
class ν΄λμ€μ΄λ¦ implements μΈν°νμ΄μ€μ΄λ¦{
    // μΈν°νμ΄μ€μ μ μλ μΆμλ©μλ κ΅¬ν
}
class Fighter implements Fightable {
    public void move(int x, int y){}
    public void attack(Unit u){}
}

/* λ§μΌ κ΅¬ννλ μΈν°νμ΄μ€μ λ©μλ μ€ μΌλΆλ§ κ΅¬ννλ€λ©΄, abstractλ₯Ό λΆμ¬μ μΆμν΄λμ€λ‘ μ μΈν΄μΌν¨*/

abstract class Fighter implements Fightable {
    public void move(int x, int y){}
}

class Fighter extends Unit implements Fightable{
    /* μ΄μ²λΌ μμκ³Ό κ΅¬ν λμμ κ°λ₯*/
}
```

```
μ€λ²λΌμ΄λ© ν  λλ μ‘°μμ λ©μλλ³΄λ€ λμ λ²μμ μ κ·Ό μ μ΄μλ₯Ό μ§μ ν΄μΌ νκΈ° λλ¬Έμ,
'public abstract'κ° μλ΅λ μΈν°νμ΄μ€ λ©μλλ₯Ό κ΅¬νν  λμλ μ κ·Ό μ μ΄μλ₯Ό λ°λμ publicμΌλ‘
ν΄μ£Όμ΄μΌ νλ€.
```

```java

public class Tv {   
    protected boolean power;
    protected boolean channel;
    protected boolean volume;
    
    public void power() { power = !power;}
    public void channelUp() { channel++;}
    public void channelDown() { channel--;}
    public void volumeUp() { volume++;}
    public void volumeDown() { volume--;}
}
public class VCR {
    protected int counter;
        
    public void play() {
        // tapeλ₯Ό μ¬μνλ€.
    }
    public void stop() {
        // μ¬μμ λ©μΆλ€.
    }
    public void reset() {
        counter = 0;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int c) {
        counter = c;
    }
}

class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());

        System.out.println("νμ¬ λ¨μ λμ " + b.money + "λ§μμλλ€.");
        System.out.println("νμ¬ λ³΄λμ€μ μλ " + b.bonusPoint + "μ μλλ€.");
    }
}

```

```java
// VCRν΄λμ€μ μ μλ λ©μλμ μΌμΉνλ μΆμλ©μλλ₯Ό κ°λ μΈν°νμ΄μ€λ₯Ό μμ±
public interface IVCR {
    public void play();
    public void stop();
    public void reset();
    public int getCounter();
    public void setCounter(int c);
}
```

```java
// IVCR μΈν°νμ΄μ€λ₯Ό κ΅¬ννκ³  Tvν΄λμ€λ‘λΆν° μμλ°λ TVCRν΄λμ€λ₯Ό μμ±
// VCRν΄λμ€ νμμ μ°Έμ‘°λ³μλ₯Ό λ©€λ²λ³μλ‘ μ μΈνμ¬ IVCRμΈν°νμ΄μ€μ μΆμ λ©μλλ₯Ό κ΅¬ννλλ° μ¬μ©
public class TVCR extends Tv implements IVCR {
    VCR vcr = new VCR();
    public void play() {
        vcr.play();
    }
    public void stop() {
        vcr.stop();
    }
    public void reset() {
        vcr.reset();
    }
    public int getCounter() {
        vcr.getCounter();
    }
    public void setCounter(int c) {
        return vcr.setCounter(c);
    }
}
```
- VCRν΄λμ€μ μΈμ€ν΄μ€λ₯Ό μ¬μ©νλ©΄ μμ½κ² λ€μ€μμμ κ΅¬νν  μ μμ
- VCRν΄λμ€μ λ΄μ©μ΄ λ³κ²½λμ΄λ λ³κ²½λ λ΄μ©μ΄ TVCRν΄λμ€μλ μλμ μΌλ‘ λ°μ

#### μΈν°νμ΄μ€λ₯Ό μ΄μ©ν λ€νμ±
> ν΄λΉ μΈν°νμ΄μ€ νμμ μ°Έμ‘°λ³μλ‘ μ΄λ₯Ό κ΅¬νν ν΄λμ€μ μΈμ€ν΄μ€λ₯Ό μ°Έμ‘°ν  μ μκ³ , μΈν°νμ΄μ€ νμμΌλ‘μ νλ³νλ κ°λ₯

```java
/* μΈν°νμ΄μ€ Fightableμ ν΄λμ€ Fighterκ° κ΅¬ννμ λ, 
 * FighterμΈμ€ν΄μ€λ₯Ό Fightableνμμ μ°Έμ‘°λ³μλ‘ μ°Έμ‘°νλ κ²μ΄ κ°λ₯ */
Fightable f = (Fightable)new Fighter();
or
Fightable f = new Fighter();
```


```
μΈν°νμ΄μ€λ λ©μλμ λ§€κ°λ³μμ νμμΌλ‘ μ¬μ©λ  μ μλ€.
void attack(Fightable f){
    ///
}
- λ©μλ νΈμΆ μ ν΄λΉ μΈν°νμ΄μ€λ₯Ό κ΅¬νν ν΄λμ€μ μΈμ€ν΄μ€λ₯Ό λ§€κ°λ³μλ‘ μ κ³΅ν΄μΌ ν¨
- attack λ©μλλ₯Ό νΈμΆν  λλ λ§€κ°λ³μλ‘ FightableμΈν°νμ΄μ€λ₯Ό κ΅¬νν ν΄λμ€μ μΈμ€ν΄μ€λ₯Ό λκ²¨μ£Όμ΄μΌ ν¨   
```

```java
class Fighter extends Unit implements Fightable {
    public void move(int x, int y){ /**/ }
    public void attack(Fightable f) { /**/ } // attack(new Fighter()) μ κ°μ
}

/* λ©μλμ λ¦¬ν΄νμμΌλ‘ μΈν°νμ΄μ€μ νμμ μ§μ νλ κ² μ­μ κ°λ₯ */
Fightable method(){
    Fighter f = new Fighter();
    return f; // return new Fighter();
}
```

#### μΈν°νμ΄μ€μ μ₯μ 
```
- κ°λ°μκ°μ λ¨μΆμν¬ μ μλ€.
- νμ€νκ° κ°λ₯νλ€.
- μλ‘ κ΄κ³μλ ν΄λμ€λ€μκ² κ΄κ³λ₯Ό λ§Ίμ΄ μ€ μ μλ€.
- λλ¦½μ μΈ νλ‘κ·Έλλ°μ΄ κ°λ₯νλ€.
```

```java
interface Liftable{
    void liftOff();
    void move(int x, int y);
    void stop();
    void land();
}


/* κ±΄λ¬Όμ μ΄λ£¨λ νΉμ  ν΄λμ€ λ κ°μμλ§ λμνλ λ©μλλ₯Ό μΆκ°νκ³  μΆμ λλ? */
class Barrack extends Building implements Liftable{
    LiftableImpl l = new LIftableImpl();
    void liftOff() { l.liftOff(); }
    void move(int x, int y){ l.move(x, y);}
    void stop(){l.stop();}
    void land(){l.land();}
    void trainMarine(){ /* λ΄μ©μλ΅ */}
}
class Factory extends Building implements Liftable{
    LiftableImpl l = new LIftableImpl();
    void liftOff() { l.liftOff(); }
    void move(int x, int y){ l.move(x, y);}
    void stop(){l.stop();}
    void land(){l.land();}
    void makeTank(){ /* λ΄μ©μλ΅ */}
}
```

#### μΈν°νμ΄μ€μ μ΄ν΄
```
- ν΄λμ€λ₯Ό μ¬μ©νλ μͺ½(User)κ³Ό ν΄λμ€λ₯Ό μ κ³΅νλ μͺ½(Provider)μ΄ μλ€.
- λ©μλλ₯Ό μ¬μ©(νΈμΆ)νλ μͺ½(User)μμλ μ¬μ©νλ €λ λ©μλ(Provider)μ μ μΈλΆλ§ μλ©΄λλ€.
```

#### λν΄νΈ λ©μλμ static λ©μλ
> κΈ°μ‘΄μλ μΈν°νμ΄μ€μ μΆμ λ©μλλ§ μ μΈν  μ μμμ§λ§, JDK1.8λΆν° λν΄νΈ λ©μλμ staticλ©μλλ μΆκ°ν  μ μκ²λ¨

- λν΄νΈλ©μλ
  - μΆμ λ©μλμ κΈ°λ³Έμ μΈ κ΅¬νμ μ κ³΅νλ λ©μλ
  - μΆμ λ©μλκ° μλκΈ° λλ¬Έμ λν΄νΈ λ©μλκ° μλ‘ μΆκ°λμ΄λ ν΄λΉ μΈν°νμ΄μ€λ₯Ό κ΅¬νν ν΄λμ€λ₯Ό λ³κ²½νμ§ μμλ λλ€.
  ```
  - μλ‘ μΆκ°λ λν΄νΈ λ©μλκ° κΈ°μ‘΄μ λ©μλμ μ΄λ¦μ΄ μ€λ³΅λμ΄ μΆ©λλλ κ²½μ° ν΄κ²°κ·μΉ
  1. μ¬λ¬ μΈν°νμ΄μ€μ λν΄νΈ λ©μλ κ°μ μΆ©λ
    - μΈν°νμ΄μ€λ₯Ό κ΅¬νν ν΄λμ€μμ λν΄νΈ λ©μλλ₯Ό μ€λ²λΌμ΄λ©ν΄μΌ νλ€.
  2. λν΄νΈ λ©μλμ μ‘°μ ν΄λμ€μ λ©μλ κ°μ μΆ©λ
    - μ‘°μ ν΄λμ€μ λ©μλκ° μμλκ³ , λν΄νΈ λ©μλλ λ¬΄μλλ€.
  ```
  
