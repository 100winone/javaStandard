### ๐กDay21 ์ปฌ๋ ์ ํ๋ ์์ - Stack๊ณผ Queue
> ์ด ๊ธ์ ๋จ๊ถ์ฑ๋์ ์๋ฐ์ ์ ์ 3/e๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ๊ณต๋ถํ ๋ด์ฉ์ ์ ๋ฆฌํ ๊ธ์๋๋ค.
>
> **์์ค์ ๋ฆฌ**: https://github.com/100winone/javaStandard

#### Stack๊ณผ Queue
- Stack : LIFO(Last In First Out)
  - ์์ฐจ์ ์ผ๋ก ๋ฐ์ดํฐ๋ฅผ ์ถ๊ฐํ๊ณ  ์ญ์ ํ๊ธฐ ๋๋ฌธ์ ArrayList๊ฐ ์ ํฉ
- Queue : FIFO(First In Last Out)
  - ์ฒซ ๋ฒ์งธ ๋ฐ์ดํฐ๋ฅผ ์ญ์ ํ๋ฏ๋ก ๋ฐ์ดํฐ ์ถ๊ฐ/์ญ์ ๊ฐ ์ฌ์ด LinkedList๋ก ๊ตฌํํ๋๊ฒ์ด ์ ํฉ
  

> ์คํ์ Stackํด๋์ค๋ก ๊ตฌํํ์ฌ ์ ๊ณตํ์ง๋ง, ํ๋ Queue์ธํฐํ์ด์ค๋ก๋ง ์ ์ํด๋๊ณ  ๋ณ๋์ ํด๋์ค๋ฅผ ์ ๊ณตํ์ง ์์. But. Queue์ธํฐํ์ด์ค๋ฅผ ๊ตฌํํ ํด๋์ค๋ค์ค ํ๋๋ฅผ ์ฌ์ฉํ๋ฉด ๋จ

```
์คํ์ ํ์ฉ ์ - ์์๊ณ์ฐ, ์์๊ดํธ๊ฒ์ฌ, ์๋ํ๋ก์ธ์์ undo/redo, ์น๋ธ๋ผ์ฐ์ ์ ๋ค๋ก/์์ผ๋ก
ํ์ ํ์ฉ ์ - ์ต๊ทผ์ฌ์ฉ๋ฌธ์, ์ธ์์์ ๋๊ธฐ๋ชฉ๋ก, ๋ฒํผ(buffer)
```

#### PriorityQueue
- Queue์ธํฐํ์ด์ค์ ๊ตฌํ์ฒด
- ์ ์ฅํ ์์์ ๊ด๊ณ์์ด ์ฐ์ ์์ ๋์ ๊ฒ๋ถํฐ ๊บผ๋ด๊ฒ๋จ
- null์ ์ ์ฅํ๊ฒ ๋๋ฉด NullPointerException ๋ฐ์
- ์ ์ฅ๊ณต๊ฐ์ผ๋ก ๋ฐฐ์ด์ ์ฌ์ฉํ๊ณ , ๊ฐ ์์๋ฅผ ํ(heap)์ด๋ผ๋ ์๋ฃ๊ตฌ์กฐ ํํ๋ก ์ ์ฅ
- ์ซ์์ ๊ฒฝ์ฐ ์์์๋ก ์ฐ์ ์์๊ฐ ๋์

#### Deque(Double-Ended Queue)
- ์์ชฝ ๋์ ์ถ๊ฐ/์ญ์  ๊ฐ๋ฅ
- ์กฐ์์ Queue, ๊ตฌํ์ฒด๋ก๋ ArrayDeque์ LinkedList ๋ฑ์ด ์์


|Deque|Queue|Stack|
|------|-------|------|
|offerLast()|offer()|push()|
|pollLast()|-|pop()|
|pollFirst()|poll()|-|
|peekFirst()|peek()|-|
|peekLast()|-|peek()|

#### Iterator, ListIterator, Enumeration
> ์ปฌ๋ ์์ ์ ์ฅ๋ ์์๋ฅผ ์ ๊ทผํ๋๋ฐ ์ฌ์ฉ๋๋ ์ธํฐํ์ด์ค
- ์ปฌ๋ ์์ ์ ์ฅ๋ ๊ฐ ์์์ ์ ๊ทผํ๋ ๊ธฐ๋ฅ์ ๊ฐ์ง Iterator์ธํฐํ์ด์ค๋ฅผ ์ ์ํ๊ณ , Collection์ธํฐํ์ด์ค์๋ 'Iterator'๋ฅผ ๋ฐํํ๋ iterator()๋ฅผ ์ ์

|๋ฉ์๋|์ค ๋ช|
|------|-------|
|boolean hasNext()|์ฝ์ด ์ฌ ์์๊ฐ ๋จ์์๋์ง ํ์ธ. ์์ผ๋ฉด true, ์์ผ๋ฉด false๋ฐํ|
|Object next()|๋ค์ ์์๋ฅผ ์ฝ์. next()๋ฅผ ํธ์ถํ๊ธฐ ์ ์ hasNext()๋ฅผ ํธ์ถํด์ ์ฝ์ด ์ฌ ์์๊ฐ ์๋์ง ํ์ธํ๋ ๊ฒ์ด ์์ |
|void remove()|next()๋ก ์ฝ์ด ์จ ์์๋ฅผ ์ญ์ . next()๋ฅผ ํธ์ถํ ๋ค์์ remove()๋ฅผ ํธ์ถํด์ผํจ(์ ํ์  ๊ธฐ๋ฅ)|

```java
List list = new ArrayList();
Iterator it = list.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

- Map์ธํฐํ์ด์ค๋ฅผ ๊ตฌํํ ์ปฌ๋ ์ ํด๋์ค๋ ํค(key)์ ๊ฐ(value)์ ์(pair)์ผ๋ก ์ ์ฅํ๊ณ  ์๊ธฐ ๋๋ฌธ์ keySet()์ด๋ entrySet()๊ณผ ๊ฐ์ ๋ฉ์๋๋ฅผ ํตํด iterator()๋ฅผ ํธ์ถํ  ์ ์์
```java
Map map = new HashMap();
Iterator it = map.keySet().iterator();

Iterator list = map.entrySet().iterator();
```

```
Enumeration  - iterator์ ๊ตฌ๋ฒ์ 
ListIterator - iterator์ ์๋ฐฉํฅ ์กฐํ๊ธฐ๋ฅ์ถ๊ฐ(List๋ฅผ ๊ตฌํํ ๊ฒฝ์ฐ๋ง ์ฌ์ฉ๊ฐ๋ฅ) 
```
