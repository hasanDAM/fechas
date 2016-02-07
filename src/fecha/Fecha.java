
/*
 * Paquete fecha que vamos a utilizar para crear una clase fecha y verificar  
 * que las fechas introducidas esten correctas y realizar diferentes operaciones 
 * con las fechas
 */
package fecha;
import java.util.Calendar;
import java.util.GregorianCalendar;
import numeros.Numero;
/**
 * Clase fecha
 * @author Hassan Er.
 * @version 1
 */
public class Fecha 
{//INICIO CLASE FECHA
    
    private int dia; // dia del mes
    private int mes; // el mes del año
    private int anno; // el año
    // Dias que tiene cada mes del año
    static private int [] diasMes={31,28,31,30,31,30,31,31,30,31,30,31}; // los dias de los meses

    /**
     * Constructor
     * Guarda la fecha actual 
     */
    public Fecha() {
    Calendar fecha = new GregorianCalendar();
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH)+1;
        anno = fecha.get(Calendar.YEAR);
    }
    /**
     * @return devuelve el dia
     */
    
    public int getDia() {
        return dia;
    }

    /**
     * @param dia Cambiar el valor de variable dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return devuelve el mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes cambiar el mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return el año
     */
    public int getAnno() {
        return anno;
    }
   
    /**
     * @param anno cambiar el año
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }
    /**
     * Es el método que comprueba si el año es bisiestro o no, una vez que ha hecho la comprobacion
     * obtiene los dias que tiene el mes Febrero.
     * @return Devuelve los dias que tiene febrero
     */
    public int bisiesto()
    {
        int dias=28; // los dias que tiene el mes Febrero si el año no es bisiestro
        if((anno%4==0 && anno%100!=0)|| (anno%400==0)) // comprobamos si el año es besiestro
        {
            dias=29; // los dias que tiene el mes Febrero si el año es bisiestro
        }
        return dias; // los dias del mes Febrero
    }
    /**
     * Es el método que comprueba si el año que hemos pasado es bisiestro o no, una vez
     * que ha hecho la comprobacion obtiene los dias que tiene el mes Febrero.
     * @param a el año que hemos pasado
     * @return Devuelve los dias que tiene febrero
     */
    public int bisiesto(int a)
    {
        int dias=28; // los dias que tiene el mes Febrero si el año no es bisiestro
        if((a%4==0 && a%100!=0)|| (a%400==0)) // comprobar si el años es bisiestro
        {
            dias=29; //los dias que tiene el mes Febrero si el año no es bisiestro
        }
        return dias; // los dias del mes Febrero
    }
    
    /**
     * metodo que comprueba que la fecha que se ha introducido es correcta
     * @param d dia que se ha introducido 
     * @param m mes que se ha introducido
     * @param a año que se ha introducido
     * @return devuelve Boolean True si la fecha esta bien sino devuelve false 
     */
    public boolean comprobarFecha(int d, int m, int a) {//inicio comprobarFecha
        Calendar fecha = new GregorianCalendar();
        dia = fecha.get(Calendar.DATE);
        mes = fecha.get(Calendar.MONTH);
        anno = fecha.get(Calendar.YEAR);
        
        boolean resultado = true; // resultado igual a verdadero, seponemos que la fecha esta bien
        if (a < 0) // si el año es menor que cero, es dicer que la fecha es incorrecta
        {
            resultado = false; // y ponemos que resultado es igual a falso.
        } else {
            if (m < 1 || m > 12) // si el mes es menor que 1 OR mes es mayor que 12, es decir la fecha incorrecta.
            {
                resultado = false;// resultado igual a falso.
            } else {
                diasMes[1] = bisiesto(a); // para saber los dias que tiene el mes de febrero.
                if (d < 1 || d > diasMes[m - 1]) // si el dia es menor que 1 OR mayor que los dias del mes correspondiente
                {
                    resultado = false; // resultado es falso.
                }
            }
        }
        // comprobamos si la fecha es menor o igual a la fecha de hoy. si no es, la fecha es incorrecta  
        if (resultado) {
            if (a > anno) 
            {
                resultado = false;
            } 
            else 
            {
                if (a == anno)
                {
                    if (m > mes+1)
                    {
                        resultado=false;
                    }
                    else
                    {
                        if(d > dia)
                        {
                            resultado=false;
                        }
                    }
                }
                else
                {
                    if(a < anno)
                    {
                        resultado=true;
                    }
                }
            }
        }

        return resultado; 
    }//fin comprobarFecha
    /**
     * este método es el que se encarga de calcular los dias que han pasado
     * del año hasta la fecha introducida 
     * @return Devuelve la suma de los dias transcuridos 
     */
    public int diasQHanPasadoAnno()
    {//Inicio Método diasQHanPasadoAnno
        int sumaDiasHastaFecha=0;//Variable para sumar los dias que han pasado
        int mes=1;//Variable para recorrer los meses
        diasMes[1]=bisiesto(anno);//Los dias que tiene el mes febrero, para ello le pasamos el año al metodo que se encarga de ello
        for (;mes<this.mes;mes++)//Bucle para recorre el vector diasMes, hasta la fecha introducida.
        {//Inicio del bucle "FOR"
            //Sumar los diasacumulo los dias del mes hasta que llege al introducido
            sumaDiasHastaFecha+=diasMes[mes-1];
        }//fin for
        sumaDiasHastaFecha+=dia;//sumar los dias del mes no completo
        return sumaDiasHastaFecha; // total de dias que han pasado hasta la fecha introducida
    }//Fin método diasQHanPasadoAnno   
    
    /**
     * Método que si ecarga de sumar los dias que quedan del año
     * @return devuelve los dias que quedan del año.
     */
    public int diasQuedanAno()
    {
        int diasDesdeFecha=0;// variable para sumar los dias que quedan del año
        int m=mes+1; // variable para recorrer los mese que quedan del año
        diasMes[1]=bisiesto(anno); /* comprobamos si el año es bisiesto o no, y 
        una vez que sabemos obtenemos los dias del mes febrero.        */
        diasDesdeFecha=diasMes[mes-1]-dia; // obtenemos los dias que quedan del mismo mes
        for (;m<=12;m++) // Bucle para recorrer los meses del año que quedan.
        {
            diasDesdeFecha+=diasMes[m-1]; // acumluar los dias que quedan.  
        }
        return diasDesdeFecha; // los días que han pasado.
    }
    
    /**
     * metodo de la profesora 
     * @return 
     */
    public int calcularNumeroOrden()
    {
        int orden=0;
        diasMes[1]=bisiesto();
        for (int m=0; m<mes-1;m++)
        {
            orden=orden+diasMes[m];
        }
        orden=orden+dia;
        return orden;
    }
    /**
     * Método para comparar dos fechas cual es el mayor  y el menos, o si son iguales
     * @param fecha la fecha2 que va comparar con la fecha que ha llamado a este método
     * @return devuelve 0=si son iguales, 1=Si la fecha1 es menor que la fecha2 , 2=Si la fecha2 es mayor que la fecha1
     */
    public int compararLasFechas(Fecha fecha) {
        int resultado; // variable para guardar el resultado de la comparacion.
        if (anno < fecha.anno) { // Si el año de la fecha1 es menor que el año de la fecha2
            resultado = 1; 
        } else { 
            if (this.anno > fecha.anno) { // Si el año de la fecha1 es mayor que el año de la fecha2
                resultado = 2;
            } else {
                if (this.mes < fecha.mes) { // Si el mes de la fecha1 es menor que el mes de la fecha2
                    resultado = 1;
                } else {
                    if (mes > fecha.mes) {// Si el mes de la fecha1 es mayor que el mes de la fecha2
                        resultado = 2;
                    } else {
                        if (dia < fecha.dia) { // Si el día de la fecha1 es menor que los días de la fecha2
                            resultado = 1;
                        } else {
                            if (dia > fecha.dia) {// Si el día de la fecha1 es mayor que los días de la fecha2
                                resultado = 2;
                            } else {
                                resultado = 0;
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }
    /**
     * Este método es que se encarga de calcular la distancia entre dos fechas
     * @param fecha2 es la segunda fecha introducida
     * @return devuelve el total de dias entre la 1º Fecha y 2º Fecha .
     */
    public int calcularDistanciaEnDias(Fecha fecha2) {
        int m; // variable Mes
        int dias = 0; // variable Días
        int anocopy=anno+1; // año siguiente de la fecha 1 que es la menor. para sumar los dias si son de distintos años
        int valor=0;// los dias que tiene el mes de Febrero 
        if (anno == fecha2.getAnno()) // si Año de la 1º Fecha es igual al año de 2ºFecha
        {
            //dias = fecha2.getDia() - dia;  // dias es igual a los dias de la segunda fecha - dias de la 1ºFecha
        
            if (mes == fecha2.getMes())  // Si los mes de ambas fechas iguales 
            {
            dias = diasMes[mes - 1] - dia; // restamos de los dias del mes los dias del mes de la fecha.
            }else{
            m = mes+1;  // varibale para recorrer los meses del año.
            dias=(diasMes[m]-dia); 
            while (m < (fecha2.getMes() - 1)) // Mientras m es menor que mes de la 2ºFecha
            {
                dias += diasMes[m]; // dias mas los dias del mes correspondiente.
                m++;// siguiente mes.
            }
            dias+=fecha2.getDia();// días mas los dias de la fecha2.
            }
        }
        else
        {// Si las fechas no son del mismo año
            dias = this.diasQuedanAno(); // Dias que quedan del año de la 1ºFecha
            dias += fecha2.diasQHanPasadoAnno(); // Los dias que han pasado del año de 2ºFecha
            while (anocopy < fecha2.getAnno()) // Mientras que el año de la 1ºFecha es menor que el año de la 2ºFecha
            {
                valor = bisiesto(anocopy); // obtenemos los días del mes febrero, y lo guardamos en la variable valor
                switch (valor) {
                    case 28: // si los dias del mes febrero igual a 28 es decir que el año no es bisiestro
                        dias += 365; // como no el año no es bisiestro el total de los dias del año = 365 acumulamos en la variable dias
                        break;
                    default: // el año es biesietro para ellos acumulamos 366 dias del año bisiestro a la variable días.
                        dias += 366; 
                        break;
                }
                anocopy++; // siguiente año.
            }
        }
    return dias ; // total dias entre la 1º y 2º Fecha
}
/**
 * Es el método que se encarga de calcular la fecha de  vencimiento
 * A partir de una fecha almacenada y los dias de vencimiento que se
 * introducen por teclado
 * @param day dias de vencimiento
 * @param fecha fecha del vencimiento
 */
public void calcularVencimiento(int day, Fecha fecha)
{
    int dias;// total de dias del vencimiento
    int m=mes; // el mes
    int a=anno; // el año
    dias=dia+day; // suma dias actual + dias de vencimiento que han introducido
    int days; // dias de febrero
    while (dias > diasMes[m - 1])
    {
        if (m ==2) // si el es igual a 2,es decir si es el mes febrero
        {
            days=bisiesto(a); // obtenemos los dias del mes de febrero
            dias = dias - days;  // restamos los dias del mes febrero de los dias totales de vencimiento
            m++;// mes siguiente
        }
        else
        {
            if(m == 12) // si el mes es igual a 12 
            {
                dias = dias - diasMes[m - 1]; // restamos los dias del mes diciembre de los dias total de vencimiento
                m = 1; // volvemos a contar desde el mes enero 
                a++; // el siguiente año
                
            }
            else
            {
                dias = dias - diasMes[m - 1]; // dias total de vencimiento - los dias del mes que estamos
                m++;// el siguiente mes 
            }
        }
    }
   fecha.setDia(dias);// Insertamos el dia de la fecha de vencimiento
   fecha.setMes(m);// Insertar Mes de la fecha de vencimiento
   fecha.setAnno(a);// Insertar Año de la fecha vencimiento
}

/**
 * Este método es el que se encarga de saber que fecha es, apartir del año y de los
 * dias transcuridos desde el principio del año, que se introducen por teclado.
 * @param year año desde empiezo a contrar
 * @param day total dia transcuridos desde el principio del año.
 */
public void FechaQueSeTrata(int year,int day)
{
    bisiesto(year); // comprobacion si el año es bisiestro o no.
    setAnno(year);
    mes=1; // variable para recorrer todos los meses
    int dias; // Dias del mes Febrero
    while(day > diasMes[mes-1]) // Si los dias introducidos son mayor que los dias de enero.
    {
        if (mes==2) // si es el mes febreo 
        {
            dias=bisiesto(year); /*Obtenemos los dias del mes febrero, para ello pasamos el año al otro método
            que se encarga de comprobar si es bisiestro o no */
            day=day-dias; // de los dias introducido lo restamos los días del febrero
            mes++; // el siguiente mes
        }
        else
        {
            if(mes == 12) // si es igual a 12 es decir deciembre, tenemos que volver a contrar desde el principio del año.
            {
                mes = 1; // mes igual a enero
                year++; // el siguiente año.
            }
            else
            {
                day=day-diasMes[mes-1];// dias introducidos menos los dias del mes correspondiente.
                mes++; // pasamos al siguiente mes.
            }
        }
    }
    setDia(day);// cambiamos el día 
    setMes(mes); // cambiamos el mes
    setAnno(year); // cambiamos el año 
}   
    /**
     * Método para visualizar el mes en letra
     * @return devuelve el mes en letra
     */
    public String mesEnLetra(){
        String []meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        return meses[mes-1];
    }
    
    /**
     * Metodo para pedir la fecha
     * @param fecha la fecha
     */
    public void pedirLaFecha(Fecha fecha){
        int dia = 0,mes = 0,anno = 0;// dia , mes , año
        boolean bien=false; // suponemos que la fecha que van ha introducir es falsa
        while (!bien){ // mientras es falsa
             
        dia=Numero.pedirNumero("Dia: ",1,31); // introduce el dia, ademas debe ser como minimo 1 y como maximo 31
        mes=Numero.pedirNumero("Mes: ",1,12); // introduce el mes, debe ser entre 1 y 12,
        anno=Numero.pedirNumero("Año: ",0); // introduce el año, debe ser mayor que cero.
        bien=fecha.comprobarFecha(dia, mes, anno); // enviamos el dia, mes y año al método que se encarga de comprtobar si la fecha es concreta.
        if (!bien)// sin bien es igual a false es decir la fecha es incorrecta 
        {
            System.out.println("Fecha incorrecta");
        }
        }// Fin mientras.
        fecha.setDia(dia); // insertamos el dia 
        fecha.setMes(mes); // insertamos el mes  
        fecha.setAnno(anno); // insertar el año
    }
}//fin clase FECHA




