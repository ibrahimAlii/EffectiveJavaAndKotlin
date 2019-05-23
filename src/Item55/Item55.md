# Return optionals judiciously - قم بإرجاع القيم الاختيارية بحذر 


<p><bdo dir="rtl">


قبل إصدار الجافا الثامن، كان هناك طريقتين لأخذهما بالاعتبار عند كتابة دالة ربما لا تقوم بإرجاع قيم:
- إحداث\إلقاء استثناء
- إرجاع قيمة معدومة (نال)


وهاتين الطريقتين لا يخلوان من أخطاء ومخاطر، لذا منذ إصدار الجافا الثامن أصبح هناك طريقة ثالثة وهي **القيم الاختيارية**.

الدوال التي تستخدم القيم الاختيارية كبيانات مُرجعة أكثر مرونة وأسهل في الإستخدام وأقل في الأخطاء.

في المثال التالي نريد حساب أكبر قيمة في مجموعة:

```java
// Returns max value in a collection - throw exception if empty
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            return new IllegalArgumentException("Empty collection")

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }
```

هذا الدالة تقوم بإلفاء إستثناء في حال فراغ المجموعة من العناصر، وقمنا بالإشارة في [الموضوع رقم 30](https://github.com/ibrahimAlii/EffectiveJava3rd/tree/master/src/Item30) أن الحل الأفضل هو أن نقوم بإرجاع قيم اختيارية.


```java
// Returns max value in a collection - as an Optional<E>
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty())
            return new Optional.empty();

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return Optional.of(result);
    }
```

كما رأيت هذه الطريقة الأمثل وهي إرجاع قيم اختيارية في المكان المناسب؛ فقمنا بإرجاع\
`Optional.empty()`\
والتي تقوم بإرجاع قيمة اختيارية فارغة؛ وقمنا بإرجاع\
`Optional.of(value)`\
والتي تقوم بإرجاع قيمة غير فارغة(نال)؛ وهناك مشكلة يجب أن تتفاداها أيضا وهو إدخال قيم فارغة؛ لكن عند احتمالية ارجاع قيم فارغة يمكنك استخدام\
`Optional.ofNullable(value)`\
والتي ستقوم بالتعامل مع القيم الفارغة؛ **لذلك لا تقوم بإرجاع أي قيم قيم فارغة لدوال تقوم بإرجاع قيم اختيارية أبداً** لأن هذا يُذهب الفائدة الكلية من استخدام القيم الاختيارية.

--------------------------------------------
### إرجاع قيم اختيارية عند استخدام الـ (استريم) 
```java
public static <E extends Comparable<E>> Optional<E> max(Collection<E> c){
    return c.stream().max(Comparator.naturalOrder());
}
```

## إرجاع قيمة أخرى عند عد احتواء القيم الاختيارية على قيم 
```java
//Using an optional to provide a chosen default value
String lastWordInLexicon = max(words).orElse("No words...");
```

## إلقاء إستثناء عند الحاجة 
```java
//Using an optional to throw a chosen exception
SomeObj obj = max(objcts).orElseThrow(SomeException::new);
```

## استخدام القيم عند تأكدك من وجودها 
```java
// Using optional when you know there's a return value
Element lastNobleGas = max(Elements.NOBLE_GASES).get();
```

**إذاً متى يمكنك إرجاع قيم اختيارية بدلا من القيم العادية؟**\
عند احتمالية عدم وجود بيانات مٌرجعة!


## ملخص :
**إذا وجدت نفسك تكتب دالة لا تقوم بإرجاع قيمة دائمة وتظن أنه يتوجب على المستخدم التعامل مع قيمة أظن وقتها يجب عليك استخدام القيم الاختيارية.\
ينبغي عليك الحذر من استخدام القيم الاختيارية في الحالات التي تهتم فيها بالسرعة إذا أنه من الأفضل إرجاع قيمة فارغة (نال) أو إلقاء استثناء.**
</bdo></p>