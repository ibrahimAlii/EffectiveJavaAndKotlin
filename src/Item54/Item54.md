# Return empty collections or arrays, not nulls - قم بارجاع مجموعة أو متسلسلة فارغة وليس قيمة معدومة

ليس دارجا أن ترى دوال تشبه الآتي:

```java
public class Example{
    // Return null to indicate an empty collection. Don't do this!
    /**
    * @return list containing all of the cheeses in the shop,
    * or null if no cheeses are available for purchase.
    */
    public List<Cheese> getCheeses(){
        return cheeseInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
    }
}
```

إذا اتبعت الطريقة هذه، سترغم المستخدم على كتابة المزيد من الأكواد البرمجية؛ فعلى سبيل المثال:

```java
if (cheeses != null) // سيحتاج هذا السطر كثيراً
```
هذه الطريقة تولد الكثير من الأخطاء؛ وتضفي كثير من المتاعب.

والطريقة الصحيحة لإرجاع مجموعة فارغة:

```java
public List<Cheese> getCheeses() {
    return new ArrayList<>(cheesesInStock);
}
```

وهناك طريقة أسرع قليلاً إذا كنت لا تريد إنشاء مثال جديد من الكلاس عن طريق إرجاع نفس المجموعة مرة أخرى أو إرجاع الدالة الستاتيك:

```java
// Optimization - avoid allocating empty collections
public List<Cheese> getCheeses() {
    return cheeseInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheesesInStock);
}
```

الطريقة متشابهة عند استخدام المتسلسلات :

```java
// The right way to return a possibly empty array
public Cheese[] getCheeses() {
    return cheeseInStock.toArray(new Cheese[0]);
}
```

## ملخص: 
لا تقوم بإرجاع قيمة معدومة أبداً مكان المجموعات والمتسلسلات.\
هذا يجعل كودك صعب الاستخدام ومليء بالأخطاء ومع ذلك عدم وجود أي مميزات للسرعة!.