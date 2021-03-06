package gov.usgs.wma.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "Use", propOrder =
    { "id", "rank", "code", "name", "useType"
})

@XmlRootElement(name="Use")
public class Use  {
  
  @XmlElement(name="id")
  private Long id = null;

  @XmlElement(name="rank")
  private Integer rank = null;

  @XmlElement(name="code")
  private String code = null;

  @XmlElement(name="name")
  private String name = null;

  @XmlElement(name="useType")
  private String useType = null;

 /**
   * Get id
   * @return id
  **/
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
 /**
   * Get rank
   * @return rank
  **/
  public Integer getRank() {
    return rank;
  }
  public void setRank(Integer rank) {
    this.rank = rank;
  }
 /**
   * Get code
   * @return code
  **/
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
 /**
   * Get name
   * @return name
  **/
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get use type
   * @return use type
  **/
  public String getUseType() {
    return name;
  }
  public void setUseType(String useType) {
    this.useType = useType;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Use {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    useType: ").append(toIndentedString(useType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

