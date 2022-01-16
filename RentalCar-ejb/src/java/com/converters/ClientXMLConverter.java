package com.converters;

import com.models.Car;
import com.models.Client;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

// JaxB конвертер, для генерации xml из модели
public class ClientXMLConverter {
    private ByteArrayOutputStream bos;


    public ByteArrayOutputStream convertClient(Client client) {

        bos = new ByteArrayOutputStream();

        try {
            // Создаем JaxB контекст для клиента
            JAXBContext context = JAXBContext.newInstance(Client.class);
            //берем из него маршаллер 
            Marshaller m = context.createMarshaller();
            // настраиваем форматированный вывод
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // выводим объект в выходной поток, который возвращается из функции
            m.marshal(client, bos);

        } catch (JAXBException ex) {
            System.err.println(ex.toString());
        }

        return bos;
    }
}
