public class MajorFieldsException extends RuntimeException {

    public MajorFieldsException(String field) {
        super(String.format("Обязательное поле %s не заполнено", field));
    }

}
