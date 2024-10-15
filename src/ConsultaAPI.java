import com.google.gson.annotations.SerializedName;

public record ConsultaAPI(
        @SerializedName("conversion_result") double conversionResult) {
}
