package VK;

import com.vk.api.sdk.objects.base.Sex;

public class VKInfo {
        private final String city;
        private final Sex sex;
        private final float timeZ;
        private final String name;

        public VKInfo(String city, Sex sex, float timeZ, String name) {
            this.city = city;
            this.sex = sex;
            this.timeZ = timeZ;
            this.name = name;
        }
        public String getCity() {
            return city;
        }

        public Sex getSex() {
            return sex;
        }

        public float getTimeZ() {
            return timeZ;
        }

        public String getName() {
            return name;
        }
}
