// ORM class for table 'authors'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sun May 12 14:48:03 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class authors extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("steamid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        authors.this.steamid = (Long)value;
      }
    });
    setters.put("num_games", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        authors.this.num_games = (Long)value;
      }
    });
    setters.put("num_reviews", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        authors.this.num_reviews = (Long)value;
      }
    });
  }
  public authors() {
    init0();
  }
  private Long steamid;
  public Long get_steamid() {
    return steamid;
  }
  public void set_steamid(Long steamid) {
    this.steamid = steamid;
  }
  public authors with_steamid(Long steamid) {
    this.steamid = steamid;
    return this;
  }
  private Long num_games;
  public Long get_num_games() {
    return num_games;
  }
  public void set_num_games(Long num_games) {
    this.num_games = num_games;
  }
  public authors with_num_games(Long num_games) {
    this.num_games = num_games;
    return this;
  }
  private Long num_reviews;
  public Long get_num_reviews() {
    return num_reviews;
  }
  public void set_num_reviews(Long num_reviews) {
    this.num_reviews = num_reviews;
  }
  public authors with_num_reviews(Long num_reviews) {
    this.num_reviews = num_reviews;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof authors)) {
      return false;
    }
    authors that = (authors) o;
    boolean equal = true;
    equal = equal && (this.steamid == null ? that.steamid == null : this.steamid.equals(that.steamid));
    equal = equal && (this.num_games == null ? that.num_games == null : this.num_games.equals(that.num_games));
    equal = equal && (this.num_reviews == null ? that.num_reviews == null : this.num_reviews.equals(that.num_reviews));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof authors)) {
      return false;
    }
    authors that = (authors) o;
    boolean equal = true;
    equal = equal && (this.steamid == null ? that.steamid == null : this.steamid.equals(that.steamid));
    equal = equal && (this.num_games == null ? that.num_games == null : this.num_games.equals(that.num_games));
    equal = equal && (this.num_reviews == null ? that.num_reviews == null : this.num_reviews.equals(that.num_reviews));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.steamid = JdbcWritableBridge.readLong(1, __dbResults);
    this.num_games = JdbcWritableBridge.readLong(2, __dbResults);
    this.num_reviews = JdbcWritableBridge.readLong(3, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.steamid = JdbcWritableBridge.readLong(1, __dbResults);
    this.num_games = JdbcWritableBridge.readLong(2, __dbResults);
    this.num_reviews = JdbcWritableBridge.readLong(3, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeLong(steamid, 1 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(num_games, 2 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(num_reviews, 3 + __off, -5, __dbStmt);
    return 3;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeLong(steamid, 1 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(num_games, 2 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeLong(num_reviews, 3 + __off, -5, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.steamid = null;
    } else {
    this.steamid = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.num_games = null;
    } else {
    this.num_games = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.num_reviews = null;
    } else {
    this.num_reviews = Long.valueOf(__dataIn.readLong());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.steamid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.steamid);
    }
    if (null == this.num_games) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.num_games);
    }
    if (null == this.num_reviews) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.num_reviews);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.steamid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.steamid);
    }
    if (null == this.num_games) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.num_games);
    }
    if (null == this.num_reviews) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.num_reviews);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(steamid==null?"null":"" + steamid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(num_games==null?"null":"" + num_games, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(num_reviews==null?"null":"" + num_reviews, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(steamid==null?"null":"" + steamid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(num_games==null?"null":"" + num_games, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(num_reviews==null?"null":"" + num_reviews, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.steamid = null; } else {
      this.steamid = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.num_games = null; } else {
      this.num_games = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.num_reviews = null; } else {
      this.num_reviews = Long.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.steamid = null; } else {
      this.steamid = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.num_games = null; } else {
      this.num_games = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.num_reviews = null; } else {
      this.num_reviews = Long.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    authors o = (authors) super.clone();
    return o;
  }

  public void clone0(authors o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("steamid", this.steamid);
    __sqoop$field_map.put("num_games", this.num_games);
    __sqoop$field_map.put("num_reviews", this.num_reviews);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("steamid", this.steamid);
    __sqoop$field_map.put("num_games", this.num_games);
    __sqoop$field_map.put("num_reviews", this.num_reviews);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
