# استخدم نسخ وقائية عند الحاجة - Make defensive copies when needed.

كون لغة _الجافا_ لغة آمنة هذا شيء يجعل التعامل معها ممتعاً. وهذا يضفي حصنا ومناعة عند غياب الدوال الأصلية لتجاوزات الـ:.\
`buffer`, `array`, `wild pointers` and other `memory corruption errors`.\
والتي تعد بلاءً في اللغات غير الآمنة مثل الـ "سي" و الـ"سي بلس بلس".\
في اللغات الآمنة من الممكن كتابة "كلاس" لمعرفة سياق الثوابت المحفوظة. لا يهم ما يحدث في باقي أجزاء النظام.\
وذلك ليس ممكناً في اللغات التي تتعامل مع الذاكر كمتسلسة كبيرة واحدة.

حتى في اللغات الآمنة كالجافا أنت لست معزولاً من باقي "الكلاسات" ما لم تقم ببعض الخطوات.\
**ينبغي عليك أن تقوم بكتابة برنامجك بطريقة وقائية؛ على فرضية أن مستخدمي "الكلاس" الذي صممته سيقوموا بهدم ثوابته قدر المستطاع**.

مع إمكانية تغيير القيم الداخلية لـ"كلاس" من داخل كلاس آخر؛\
فعلى سبيل المثال، المثال التالي يوضح كيف يمكن لنا تغيير القيم الداخلية لـلمتغيرات، مع أن مصمم البرنامج زعم أن المتغيرات غير قابلة للتغيير.

```java
// Broken "immutable" time period class
public final class Period{
    private final Date start;
    private final Date end;
    
    /**
    * 
    * @param start the beginning of the period
    * @param end the end of the period; must not precede start
    * @throws IllegalArgumentException if start is after end
    * @throws NullPointerException if start or end is null
    */
    public Period(Date start, Date end){
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }
    
    public Date start(){
        return start;
    }
    
    
    public Date end(){
        return end;
    }
   
}
```

ربما تتوهم أن هذا الـ"كلاس" غير قابل للتغيير؛ وهذا غير صحيح إذ أنه من السهل تغيير القيم الداخلة للكلاس؛ لأن كلاس "التاريخ" الذي استخدمناه نفسه قابل للتغيير.

```java
// Attack the internals of a Period instance
Date start = new Date();
Date end = new Date();
Period p = new Period(start, end);
end.setYear(95); // تم تغيير القيم الداخلية للكلاس!
```

طبعا بداية من الاصدار الثامن للغة الجافا لحل هذه المشكلة نستخدم كلاسات أخرى لأن "كلاس التاريخ" الذي استخدمناه عفا عليه الزمن:\
`Instant (or LocalDateTime or ZonedDateTime`

لكن لا زالت المشكلة موجودة؛ إذ أنه أحيانا نحتاج إلى استخدام كلاسات من هذا النوع؛ فما الحل!\
**لحماية القيم الداخلية؛ ينبغي عليك إنشاء نسخ وقائية لكل شيء قابل للتغيير مثل "كلاس التاريخ"**

```java
// طريقة البناء السليمة - نسخنا قيم وقائية للمدخلات
public Period(Date start, Date end){
     this.start = new Date(start.getTime());
     this.end = new Date(end.getTime());
     
      if (start.compareTo(end) > 0)
          throw new IllegalArgumentException(start + " after " + end);
    }
```

عند استخدامنا لطريقة البناء هذه محاولة تغيير البيانات الداخلية بالطريقة السابقة ستفشل ولن يكون لها تأثير؛\
**تنبيه:**\
نكتب القيم الوقائية قبل [التأكد من صحة المدخلات (الموضوع رقم 49)](https://github.com/ibrahimAlii/EffectiveJava3rd/tree/master/src/Item49/Item49.md) عملية التأكد تتم على النسخ الوقائية بدلا من الأصلية.

قد يبدوا هذا غير طبيعي، لكنه ضروري لحماية قيمك لديك من التغير من أي مكان آخر؛ في أمن الحاسوب هذه المشكلة معروفة كـ وقت-التغير/وقت الاستخدام\
time-of-check/time-of-use or TOCTOU attack [Viega01].

ولاحظ أننا لم نستخدم الدالة الناسخة "كلون" لأن "كلاس التاريخ" ليس مثال نهائي من الكلاس؛ إذ أنه من الممكن أن تقوم الدالة بإرجاع مثال من كلاس "وارث" من الكلاس الرئيسي؛لذلك:\
**لا تستخدم الدالة الناسخة لتحصل على قيم وقائية منسوخة**

بينما قمنا بحماية البيانات من التغيير في الطريقة الأولى إلا أنه ما زال من الممكن تغيير البيانات الداخلية عن طريق الـ"كلاس" نفسه؛مثل:
```java
// الهجوم الثاني على القيم الداخلية للكلاس
Date start = new Date();
Date end = new Date();
Period p = new Period(start, end);
p.end.setYear(95); // تم تغيير القيم الداخلية للكلاس!
```

للحماية من الهجوم الثاني، ينبغي تغيير دوال الوصول لتقوم بإرجاع نسخ وقائية للأشياء القابلة للتعديل؛ كالتالي:

```java
// دوال الوصول السليمة - إنشاء نسخ وقاائية
public Date start(){
    return new Date(start.getTime());
}
    
    
public Date end(){
    return new Date(end.getTime());
} 
```

بعد هذه التغييرات أصبح الـ"كلاس" الخاص بنا غير قابل للتغيير حقيقة!

**لمزيد من المعلومات تفقد هذه الموضوع المتعلقة بها:**

 [موضوع#13](https://github.com/ibrahimAlii/EffectiveJava3rd/tree/master/src/Item13)\
 [موضوع#15](https://github.com/ibrahimAlii/EffectiveJava3rd/tree/master/src/Item15)\
 [موضوع#17](https://github.com/ibrahimAlii/EffectiveJava3rd/tree/master/src/Item17) 


### تلخيص:
**إذا كان الـ"كلاس" الخاص بك يحمل قيما متغيرة التي يستخدمها مستخدي الكلاس؛ ينبغي عليك وضع نسخ وقائية لهذا المكون.\
لو كانت النسخ الوقائية باهظة الثمن من حيث الذاكرة وغيره، وهناك ثقة لمستخدم الكلاس؛ إذا يمكنك استبدالها بتعليقات تفيد المستخدم وتنبهه عن عد تغيير المكونات الداخلية للمتغيرات.**