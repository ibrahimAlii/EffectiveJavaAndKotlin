# Check parameters for validity - التأكد من صحة المدخلات

معظم الدوال وأمثلة الـ"كلاسات" تحتاج إلى بعض التقييدات على المدخلات؛ فعلى سبيل المثال:\
قيمة المؤشر(اندكس) يجب أن تكون أكبر من صفر وكذلك أي شيء(أوبجكت) يجب أن يحمل قيمة و أن لا يكون فارغا.\
وينبغي عليك التعليق في بداية الدالة وشرح متطلباتها وكذلك الإثتثناء المتوقع حدوثه عند مخالفة هذه الشروط.

و التأكد من صحة المدخلات في بداية الدالة مهم لعدة أمور:
- ستقوم الدالة بالتأكد من المدخلات قبل الشروع في أي عملية أخرى **(السرعة)** م.
- سيتم اظهار الاثتثناء بالشكل المطلوب والسليم **(النظافة)** م.

إذا لم تقم بتفقد المدخلات بشكل جيد هناك عدة أخطاء ممكن حدوثها:
- صعوبة التعرف على المشكلة التي تظهر أثناء العملية
- قد تعمل الدالة بدون اثتثناءات لكن يتم إرجاع قيم خاطئة
- وأسوأ شيء؛ أنه ممكن أن تقوم الدالة بارجاع القيم الصحيحة في بعض الأحيان وأحيان أخرى لا - إذ يتم تسوية الأخطاء داخليا!! - خلي بالك بقى

للدوال من النوع العام والمحمي استخدام تاج "ثرو":\
`@throw`\
لكي توضح التقييدات الخاصة بك على المدخلات.

بمجرد قيامك بتوضيح وكتابة تقييداتك على مدخلات الدالة؛ من السهل وقتها الشروع في وضع تقييداتك؛\
مثال:

```java
class Example{
    
    
    /**
    * Returns a BigInteger whose value is (this mod m). 
    * This method differs from remainder method in that it always returns a non-negative BigInteger.
    * 
    * @param m the modulus. which must be positive.
    * @return this mod m
    * @throws ArithmeticException if m is less than or equal to 0
    */
    public BigInteger mod(BigInteger m){
        if (m.signum() <= 0)
            throw new ArithmeticException("Modulus <= 0: " + m);
        
        // Do the computation
    }
}
```
والآن لاحظ أننا لم نذكر أن الدالة تقوم بتفقد الشئ(أوبجكت) إذا كان فارغا أم لا(نال)؛ لأن ذلك قد تم في مستوى الكلاس نفسه الخاص بـ الـ "بيج انتجر".\
ممكن في حالتنا استخدام الرمز\
`@Nullable`\
لكن هذه الطريقة ليست شائعة؛ ولا يٌفضل استخدامها.

**Objects.requireNonNull :**\
قد ام إضافة هذه الدالة في الجافا بداية من الإصدار السابع؛ وهذه الدالة سهلة ومرنة في الإستخدام لذا لا حاجة في التأكد من صحة المدخلات يديك يدوياً.

وهنا استخدام داخلي لهذه الدالة ويمكن أيضاً استخدامها كدالة حرة بدون اعتماد على قيمة مطلقة، يعتمد هذا على حالتك:

```java
// Inline use of java's null-checking facility
this.someThings = Objects.requireNonNull(someThing, "someThing");
```

ومنذ إصدار الجافا 9 قد تم إضافة بعض الدوال لمساعدتك في التأكد من السلاسل والقوائم (ليست، أررايز) وهذه الدوال موجودة بداخل الحزمة\
`java.util.Objects` -> `checkFromIndexSize`, `checkFromToIndex`, `checkIndex`.

**Assertion :**\
لاستعادة معلوماتك عنها: [درس سريع](https://www.youtube.com/watch?v=493S7W0N7-4)\
عند كتابتك للدالة يمكنك التحكم بهذه القيم المنطقية عن طريق الفرضية\
مثال:
```java
private static void sort(long a[], int offset, int length){
    assert a != null;
    assert offset >= 0 && offset <= a.length;
    assert length >= 0 && length <= a.lenght - offset;
}
```


### الملخص 
**في كل مرة تقوم بكتابة دالة أو ما شابه، يجب أن تفكر في التقييدات التي ستضعها على المدخلات.\
يجب عليك أيضا كتابة تعليقات لشرح هذه التقييدات مع وضع التنفيذ في بداية الدالة.\
ربما من الأفضل أن تعود نفسك على هذا عند كتابة الكود.**