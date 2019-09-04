package com.fire.server.domain;

import com.google.protobuf.*;

import java.io.IOException;
import java.io.InputStream;

public final class PersonDomain {
    private PersonDomain() {}
    public static void registerAllExtensions(
            ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            ExtensionRegistry registry) {
        registerAllExtensions(
                (ExtensionRegistryLite) registry);
    }
    public interface PersonOrBuilder extends
            // @@protoc_insertion_point(interface_extends:com.zzqfsy.vertxtcp.domain.Person)
            MessageOrBuilder {

        /**
         * <code>int32 id = 1;</code>
         */
        int getId();

        /**
         * <code>string name = 2;</code>
         */
        String getName();
        /**
         * <code>string name = 2;</code>
         */
        ByteString
        getNameBytes();

        /**
         * <code>string email = 3;</code>
         */
        String getEmail();
        /**
         * <code>string email = 3;</code>
         */
        ByteString
        getEmailBytes();
    }
    /**
     * Protobuf type {@code com.zzqfsy.vertxtcp.domain.Person}
     */
    public  static final class Person extends
            GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:com.zzqfsy.vertxtcp.domain.Person)
            PersonOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use Person.newBuilder() to construct.
        private Person(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private Person() {
            id_ = 0;
            name_ = "";
            email_ = "";
        }

        @Override
        public final UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private Person(
                CodedInputStream input,
                ExtensionRegistryLite extensionRegistry)
                throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields =
                    UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 8: {

                            id_ = input.readInt32();
                            break;
                        }
                        case 18: {
                            String s = input.readStringRequireUtf8();

                            name_ = s;
                            break;
                        }
                        case 26: {
                            String s = input.readStringRequireUtf8();

                            email_ = s;
                            break;
                        }
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final Descriptors.Descriptor
        getDescriptor() {
            return PersonDomain.internal_static_com_zzqfsy_vertxtcp_domain_Person_descriptor;
        }

        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return PersonDomain.internal_static_com_zzqfsy_vertxtcp_domain_Person_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Person.class, Builder.class);
        }

        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        /**
         * <code>int32 id = 1;</code>
         */
        public int getId() {
            return id_;
        }

        public static final int NAME_FIELD_NUMBER = 2;
        private volatile Object name_;
        /**
         * <code>string name = 2;</code>
         */
        public String getName() {
            Object ref = name_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                ByteString bs = (ByteString) ref;
                String s = bs.toStringUtf8();
                name_ = s;
                return s;
            }
        }
        /**
         * <code>string name = 2;</code>
         */
        public ByteString
        getNameBytes() {
            Object ref = name_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                name_ = b;
                return b;
            } else {
                return (ByteString) ref;
            }
        }

        public static final int EMAIL_FIELD_NUMBER = 3;
        private volatile Object email_;
        /**
         * <code>string email = 3;</code>
         */
        public String getEmail() {
            Object ref = email_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                ByteString bs = (ByteString) ref;
                String s = bs.toStringUtf8();
                email_ = s;
                return s;
            }
        }
        /**
         * <code>string email = 3;</code>
         */
        public ByteString getEmailBytes() {
            Object ref = email_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8(
                                (String) ref);
                email_ = b;
                return b;
            } else {
                return (ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output)
                throws IOException {
            if (id_ != 0) {
                output.writeInt32(1, id_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(output, 2, name_);
            }
            if (!getEmailBytes().isEmpty()) {
                GeneratedMessageV3.writeString(output, 3, email_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (id_ != 0) {
                size += CodedOutputStream
                        .computeInt32Size(1, id_);
            }
            if (!getNameBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(2, name_);
            }
            if (!getEmailBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(3, email_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Person)) {
                return super.equals(obj);
            }
            Person other = (Person) obj;

            boolean result = true;
            result = result && (getId()
                    == other.getId());
            result = result && getName()
                    .equals(other.getName());
            result = result && getEmail()
                    .equals(other.getEmail());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + ID_FIELD_NUMBER;
            hash = (53 * hash) + getId();
            hash = (37 * hash) + NAME_FIELD_NUMBER;
            hash = (53 * hash) + getName().hashCode();
            hash = (37 * hash) + EMAIL_FIELD_NUMBER;
            hash = (53 * hash) + getEmail().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Person parseFrom(
                java.nio.ByteBuffer data)
                throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Person parseFrom(
                java.nio.ByteBuffer data,
                ExtensionRegistryLite extensionRegistry)
                throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Person parseFrom(
                ByteString data)
                throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Person parseFrom(
                ByteString data,
                ExtensionRegistryLite extensionRegistry)
                throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Person parseFrom(byte[] data)
                throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Person parseFrom(
                byte[] data,
                ExtensionRegistryLite extensionRegistry)
                throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Person parseFrom(InputStream input)
                throws IOException {
            return GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static Person parseFrom(
                InputStream input,
                ExtensionRegistryLite extensionRegistry)
                throws IOException {
            return GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static Person parseDelimitedFrom(InputStream input)
                throws IOException {
            return GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static Person parseDelimitedFrom(
                InputStream input,
                ExtensionRegistryLite extensionRegistry)
                throws IOException {
            return GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static Person parseFrom(
                CodedInputStream input)
                throws IOException {
            return GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static Person parseFrom(
                CodedInputStream input,
                ExtensionRegistryLite extensionRegistry)
                throws IOException {
            return GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(Person prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code com.zzqfsy.vertxtcp.domain.Person}
         */
        public static final class Builder extends
                GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:com.zzqfsy.vertxtcp.domain.Person)
                PersonOrBuilder {
            public static final Descriptors.Descriptor
            getDescriptor() {
                return PersonDomain.internal_static_com_zzqfsy_vertxtcp_domain_Person_descriptor;
            }

            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return PersonDomain.internal_static_com_zzqfsy_vertxtcp_domain_Person_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                Person.class, Builder.class);
            }

            // Construct using com.zzqfsy.vertxtcp.domain.PersonDomain.Person.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                id_ = 0;

                name_ = "";

                email_ = "";

                return this;
            }

            public Descriptors.Descriptor
            getDescriptorForType() {
                return PersonDomain.internal_static_com_zzqfsy_vertxtcp_domain_Person_descriptor;
            }

            public Person getDefaultInstanceForType() {
                return Person.getDefaultInstance();
            }

            public Person build() {
                Person result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public Person buildPartial() {
                Person result = new Person(this);
                result.id_ = id_;
                result.name_ = name_;
                result.email_ = email_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(Message other) {
                if (other instanceof Person) {
                    return mergeFrom((Person)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Person other) {
                if (other == Person.getDefaultInstance()) return this;
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (!other.getName().isEmpty()) {
                    name_ = other.name_;
                    onChanged();
                }
                if (!other.getEmail().isEmpty()) {
                    email_ = other.email_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    CodedInputStream input,
                    ExtensionRegistryLite extensionRegistry)
                    throws IOException {
                Person parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Person) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int id_ ;
            /**
             * <code>int32 id = 1;</code>
             */
            public int getId() {
                return id_;
            }
            /**
             * <code>int32 id = 1;</code>
             */
            public Builder setId(int value) {

                id_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int32 id = 1;</code>
             */
            public Builder clearId() {

                id_ = 0;
                onChanged();
                return this;
            }

            private Object name_ = "";
            /**
             * <code>string name = 2;</code>
             */
            public String getName() {
                Object ref = name_;
                if (!(ref instanceof String)) {
                    ByteString bs =
                            (ByteString) ref;
                    String s = bs.toStringUtf8();
                    name_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <code>string name = 2;</code>
             */
            public ByteString
            getNameBytes() {
                Object ref = name_;
                if (ref instanceof String) {
                    ByteString b =
                            ByteString.copyFromUtf8(
                                    (String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (ByteString) ref;
                }
            }
            /**
             * <code>string name = 2;</code>
             */
            public Builder setName(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                name_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string name = 2;</code>
             */
            public Builder clearName() {

                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }
            /**
             * <code>string name = 2;</code>
             */
            public Builder setNameBytes(
                    ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                name_ = value;
                onChanged();
                return this;
            }

            private Object email_ = "";
            /**
             * <code>string email = 3;</code>
             */
            public String getEmail() {
                Object ref = email_;
                if (!(ref instanceof String)) {
                    ByteString bs =
                            (ByteString) ref;
                    String s = bs.toStringUtf8();
                    email_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <code>string email = 3;</code>
             */
            public ByteString
            getEmailBytes() {
                Object ref = email_;
                if (ref instanceof String) {
                    ByteString b =
                            ByteString.copyFromUtf8(
                                    (String) ref);
                    email_ = b;
                    return b;
                } else {
                    return (ByteString) ref;
                }
            }
            /**
             * <code>string email = 3;</code>
             */
            public Builder setEmail(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                email_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string email = 3;</code>
             */
            public Builder clearEmail() {

                email_ = getDefaultInstance().getEmail();
                onChanged();
                return this;
            }
            /**
             * <code>string email = 3;</code>
             */
            public Builder setEmailBytes(
                    ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                email_ = value;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:com.zzqfsy.vertxtcp.domain.Person)
        }

        // @@protoc_insertion_point(class_scope:com.zzqfsy.vertxtcp.domain.Person)
        private static final Person DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new Person();
        }

        public static Person getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final Parser<Person>
                PARSER = new AbstractParser<Person>() {
            public Person parsePartialFrom(
                    CodedInputStream input,
                    ExtensionRegistryLite extensionRegistry)
                    throws InvalidProtocolBufferException {
                return new Person(input, extensionRegistry);
            }
        };

        public static Parser<Person> parser() {
            return PARSER;
        }

        @Override
        public Parser<Person> getParserForType() {
            return PARSER;
        }

        public Person getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final Descriptors.Descriptor
            internal_static_com_zzqfsy_vertxtcp_domain_Person_descriptor;
    private static final
    GeneratedMessageV3.FieldAccessorTable
            internal_static_com_zzqfsy_vertxtcp_domain_Person_fieldAccessorTable;

    public static Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static  Descriptors.FileDescriptor
            descriptor;
    static {
        String[] descriptorData = {
                "\n\023person-domain.proto\022\032com.zzqfsy.vertxt" +
                        "cp.domain\"1\n\006Person\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030" +
                        "\002 \001(\t\022\r\n\005email\030\003 \001(\tb\006proto3"
        };
        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
                    public ExtensionRegistry assignDescriptors(
                            Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new Descriptors.FileDescriptor[] {
                        }, assigner);
        internal_static_com_zzqfsy_vertxtcp_domain_Person_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_com_zzqfsy_vertxtcp_domain_Person_fieldAccessorTable = new
                GeneratedMessageV3.FieldAccessorTable(
                internal_static_com_zzqfsy_vertxtcp_domain_Person_descriptor,
                new String[] { "Id", "Name", "Email", });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
