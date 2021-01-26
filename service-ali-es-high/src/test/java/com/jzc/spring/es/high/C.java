package com.jzc.spring.es.high;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class C {

    public static void main(String[] args) {

//        for (Object shopId : shopList) {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("\"");
//            stringBuilder.append("dynamic_");
//            stringBuilder.append(shopId);
//            stringBuilder.append("_dealCount");
//            stringBuilder.append("\"");
//            stringBuilder.append(":");
//            stringBuilder.append("${__Random(1,999)}");
//            stringBuilder.append(",");
//
//            System.out.println(stringBuilder.toString());
//        }

//        for (Object shopId : shopList) {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("\"");
//            stringBuilder.append("dynamic_");
//            stringBuilder.append(shopId);
//            stringBuilder.append("_channelGoodsStatus");
//            stringBuilder.append("\"");
//            stringBuilder.append(":");
//            stringBuilder.append("${__Random(0,1)}");
//            stringBuilder.append(",");
//
//            System.out.println(stringBuilder.toString());
//        }

        Map map = getMap();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object key : map.keySet()) {
            stringBuilder.append("\"");
            stringBuilder.append(key);
            stringBuilder.append("\"");
            stringBuilder.append(",");
        }

        System.out.println(stringBuilder.toString());
    }

    private static Map getMap() {
        Map params = new HashMap();

        long l = new Date().getTime();
        int i = RandomUtils.nextInt(1, 9999);

        params.put("channelGoodsId", UUID.randomUUID().toString());
        params.put("skuId", String.valueOf(l) + String.valueOf(i));
        params.put("standardPrice", new BigDecimal(RandomUtils.nextInt(1, 999999)));
        params.put("barcode", params.get("skuId"));
        params.put("tpSku", params.get("skuId") + "01");
        params.put("title", params.get("skuId") + "title");

        params.put("skuName", "九洲鹿 亲肤双人四件套 1.5米床/1.8米床 床上床单枕套被套200*230cm 套件家纺");
        params.put("brandName", "九洲鹿");
        params.put("thumbnail", "https://img13.360buyimg.com/n1/s200x200_jfs/t1/150217/4/3434/729520/5f17a638Ec36932e8/a4f134ef7b80a278.png");
        params.put("goodsUnit", "13");
        params.put("goodsUnitName", "套");
        params.put("goodsType", "0");
        params.put("goodsStatus", "1");
        params.put("tpCategory", "15252");
        params.put("partnerSign", "77a30e5b-d9a4-40a9-b442-ba8e59ccedaa");
        params.put("sysGoodsId", "8c116f5b-d1fa-49a3-be23-ff565f3839e1");
        params.put("sysGoodsStatus", "1");
        params.put("sysCategoryId", "7aa868ec-1807-4fbf-9bf4-343f7987a116");
        params.put("sysCategoryName", "四件套");
        params.put("merchantId", "dwj");
        params.put("sysId", "dhsc");
        params.put("channelId", "4");
        params.put("title", "九洲鹿 亲肤双人四件套 1.5米床/1.8米床 床上床单枕套被套200*230cm 套件家纺");
        params.put("channelGoodsStatus", "1");
        params.put("listingAt", "2020-09-18 05:41:54");
        params.put("delistingAt", "2099-12-31 23:59:59");
        params.put("operatedAt", "2020-09-18 05:41:54");
        params.put("isShow", 1);
        params.put("productArea", "江苏省");
        params.put("wareQD", "套件*1");

        List multimediaList = new ArrayList();

        Map multimediaMap0 = new HashMap();
        multimediaMap0.put("multType", 0);
        multimediaMap0.put("multUrl", "https://img13.360buyimg.com/n12/s750x750_jfs/t1/150217/4/3434/729520/5f17a638Ec36932e8/a4f134ef7b80a278.png");
        multimediaMap0.put("skuId", params.get("skuId"));
        multimediaList.add(multimediaMap0);

        Map multimediaMap1 = new HashMap();
        multimediaMap1.put("multType", 0);
        multimediaMap1.put("multUrl", "https://img13.360buyimg.com/n12/s750x750_jfs/t1/87184/8/4391/588094/5de64403E3b6a9258/de3ff4380d58aa0e.jpg");
        multimediaMap1.put("skuId", params.get("skuId"));
        multimediaList.add(multimediaMap1);

        params.put("multimediaList", multimediaList);

        params.put("goodsPrices0", new BigDecimal(RandomUtils.nextInt(1, 999999)));
        params.put("goodsPrices1", new BigDecimal(RandomUtils.nextInt(1, 999999)));
        params.put("goodsPrices2", new BigDecimal(RandomUtils.nextInt(1, 999999)));

        return params;
    }

    public static List shopList = new ArrayList(){{
        add("008a2ad0-dc1f-4fc4-9c5e-94d03bd5b9d0");
        add("01cbe551-cf9d-4b67-95a4-7b897563388c");
        add("02a3ad24-ee35-4489-8ea9-6e4ad5427dac");
        add("03a26b36-f920-410d-b558-c103b58c264b");
        add("03c2425c-ac5a-481a-abab-6b80349719a5");
        add("04abc13a-44cc-4412-90b5-1052b8199683");
        add("04efd48b-4a71-450e-a9fb-7e4288ada24c");
        add("04f67d08-faa1-4b62-bfcc-a9c33cebe64a");
        add("05941afc-2880-469f-94c0-c083bffdf31a");
        add("05ae28a2-228c-4f87-ad73-5453e6bebb2e");
        add("0616832b-f585-4d86-8463-6dc281cd6a76");
        add("064e1cb7-4af8-4d35-8a9e-61009fe77df9");
        add("06a31e41-82d6-4cd5-bc44-313e7b7bc00a");
        add("0895dd80-f6ab-49d8-8d3a-254aabb67b66");
        add("08a964fd-41bc-4d0c-9ef7-62e1afdffafe");
        add("09704ab9-3a09-4efc-83e9-116b6e117495");
        add("09874609-6a19-40b6-8664-05eb31c4a961");
        add("09c7ffaa-86b7-48e3-a67e-601a69bcb81c");
        add("09d14960-6e92-44c7-8d96-16aa4699af34");
        add("0b10e450-8823-45d9-ad26-da276baff006");
        add("0b18775f-fdf5-4297-bf58-82ff08f3d378");
        add("0be4dc26-5b66-4f88-8cdc-fc4081468463");
        add("0cb84b09-fb3d-48a5-a30b-319463acbb5e");
        add("0cf348df-f78f-4d50-8604-4ff092b36e39");
        add("0d55528c-3d95-4cd3-b6df-2ab0084485dd");
        add("0daa010a-79bf-42de-9619-0b68a95027e6");
        add("0def2fb7-85c3-44e9-bf9c-8b4a74f71c26");
        add("0dfba0b4-a3a6-4246-af34-cac184d11a2a");
        add("0e812948-ef78-4410-83ad-d4601b5a6c54");
        add("0f276d61-39f4-41e7-960a-643240222312");
        add("0f3244c2-962c-48a0-9628-5c8f4705314a");
        add("0f5b1f1a-1951-47a0-aadf-81996fba1a09");
        add("0f7c833b-77dc-4bb4-b0f4-3b71c195153f");
        add("1034f722-6ca3-4577-aec7-8242d115421f");
        add("11175462-1e42-4914-a230-4ce1c0b9058d");
        add("112e17a5-ca63-40fc-999f-7114c552aa56");
        add("1297f0fb-1f7c-487f-9720-faf27de5fe8f");
        add("13e028b7-d061-4b4b-97e7-e3568d0bebd7");
        add("144cd937-fb6f-4da8-bdd2-262290cd669f");
        add("146699bb-b79f-4f7e-947e-42badc679078");
        add("156b0a91-5142-43b8-b639-62b8e3526ecd");
        add("15a89183-aab2-4b95-84f1-9ebc0c38d3f7");
        add("1696ab11-27f5-4fda-a1a6-6b53513a949d");
        add("16c49363-6bf0-4ee4-980d-edc0f6377049");
        add("173548d7-7ad6-48f2-a4f7-cef3e30b1977");
        add("1833a8b3-c096-403c-a2ef-56a89cc6a741");
        add("183fc4cc-b4d9-46eb-95c5-8c21bb23b6b4");
        add("185f00b7-444c-48ac-b5df-2d9a956d5ba1");
        add("18f98ecc-2ca5-4948-829a-fae2fb134b20");
        add("19064cbe-2405-4dc4-9716-aabc624e641d");
        add("1add08e5-cb05-472b-82cd-85ba80b04f12");
        add("1af70aa7-e2b8-403f-b061-1f2c86c4e89b");
        add("1c6fc78f-2ffb-4676-bf94-0dc36375e2e4");
        add("1c81c1ca-6557-4056-be66-6c4fadbf069e");
        add("1d04c346-492f-4bd8-8e31-6ece22d83a85");
        add("1d4e5e76-9640-4e50-8153-62ad5741fdd6");
        add("1e6eb3ba-a37e-4618-8ba2-7038a9b4b1c4");
        add("1ebbe15f-f7a3-4ed5-bcb6-9b038100e14f");
        add("1edd795d-008c-42bc-895c-24200eb09148");
        add("1f099335-cd80-4468-a35b-db97b1ed32c2");
        add("20213f87-d6e5-4cbf-be34-296818d698a7");
        add("203fa9e3-77b9-4c68-b866-59a32c200193");
        add("20a98a0e-287a-41d9-a052-27bcfdb4d34c");
        add("20c8cbc5-8681-4204-821b-f1e3d544a6a4");
        add("21d9a213-db0c-4764-94de-3da60a00c560");
        add("21ec8133-78e8-499b-8a15-bb400049ef3f");
        add("2255e53e-b149-4086-a4cb-5ee273bc668d");
        add("232dd5ea-c794-4517-a7bf-71dcdb34a305");
        add("237388fb-45a1-4dea-8a27-a55d1551c780");
        add("23910cb4-978d-42d3-956f-22a4c05e96d6");
        add("23d26dd8-20b7-4159-88bf-6d91504d3dce");
        add("23d52092-3a67-4dcf-8287-43c860eed49a");
        add("250c7e6e-dbd8-4eb8-9c0d-2bd9e69896da");
        add("25bf476e-e1e8-49c2-bc2c-0370f40b5138");
        add("260323c5-30b4-4010-b2d8-5f58a7eb334b");
        add("2691fee6-bb62-4055-8dac-d119eeb3e1e5");
        add("26d8da9e-618a-4145-b0b0-be01bb30200d");
        add("2746030d-7e27-4352-8e86-10e43298fb2d");
        add("2858f691-bce4-400d-909e-1b13ae394b12");
        add("287fbfbd-f121-4817-83cb-6885619993f7");
        add("2a62d3b0-e8bb-4c5e-95af-16172667d8ad");
        add("2a83606c-064f-4c19-8d10-df916b7da464");
        add("2d209809-1d36-4a6f-ba41-74447f8ea9d8");
        add("2d2b7635-4be2-41db-9eec-13b4736592c3");
        add("2d48acbc-da3f-442f-b756-408a1477cf2f");
        add("2df3bf7d-71e3-4919-ab92-8b62be917a08");
        add("2e145263-b32e-41f5-9009-f365ac0e98bf");
        add("2e965f8d-8890-4d22-95f7-77690c813d6a");
        add("2ec3294b-7a36-4e83-af44-80035b76dccb");
        add("2fc0eb80-f23d-44df-ba83-6cc7c25ed93b");
        add("2fd57fa0-bd28-435e-9c0d-fe82508883a6");
        add("3037f33e-a29b-4cc8-8ab7-d8229adcaeab");
        add("30f8c804-8bbd-470b-b2d9-7175fc674601");
        add("32492840-1ea7-4be7-a4c1-aa0b8822acd7");
        add("325f3bf5-5bac-4a0d-98be-aecb87a50f12");
        add("3402a600-dc4c-482b-a7f6-a5e39620ddf4");
        add("3518a657-46b0-4599-bdce-9dce4c35e369");
        add("359056e9-fe0e-420f-9622-34b6f6857815");
        add("35ab5e75-79e7-404a-a9a0-a8af1a69d12a");
        add("35b84c85-6c6d-41b8-a9f7-66e44655fae5");
        add("35c98066-e5bb-4f0a-bd41-fe356ba7106d");
        add("3664aee5-93d8-495d-9324-cadfbc148dc2");
        add("3733cb15-98f7-416a-a4fd-4a628427c65b");
        add("373fd74b-0fd1-4b2e-86ff-1b99a8a437bc");
        add("37b07458-a4d5-47de-a259-87f31f371187");
        add("385f66a9-1f20-4798-b456-30b34f45ca8b");
        add("39b6e7b7-8880-4e79-8722-3c6045508911");
        add("3a3b6c90-0efb-4061-a6d1-285c43ef46c9");
        add("3a8e01f8-060a-446c-b902-a04d9e836c5c");
        add("3c2a8e99-484e-478e-b155-76bba921464a");
        add("3c701204-d194-4adf-b6ec-f6e557dd7f3f");
        add("3d1d291e-2206-4e81-9f31-a2e7832ef664");
        add("3d9a1fcb-a2c0-4e2b-9472-64c68e9570a9");
        add("3db6574f-d73c-4148-b764-821be6703649");
        add("3e0d704e-97cd-416b-9d6b-31cdb52dc369");
        add("3e3a5dc2-fd39-4877-9ae4-f1d579bec5ad");
        add("3ec242fa-081b-48cf-9358-2840f53e6f0c");
        add("4186d20c-391d-4251-ae11-e3a3eb85c1a9");
        add("42442874-19a5-40e7-854b-b810505aa1f0");
        add("4440ed83-c143-4b2d-8da5-e1a01a44170a");
        add("4558237e-c1c2-4db4-8902-ba2ca6580ae4");
        add("456c3cac-105d-4324-85cd-58d95f9014f8");
        add("45b31f1c-7741-456a-97e0-6e77ed0eab8e");
        add("476baa2b-7a63-41c7-9347-b9f0542700f7");
        add("478ea431-7937-4c33-a85b-9cd96e776d31");
        add("4878122e-e922-41a7-bab8-f9a0fe87d465");
        add("49113dd3-7d99-400c-ae69-9fd6e0f701d2");
        add("494b43c1-3551-4e3a-81c5-4a0209fde4f5");
        add("498b2ea2-74cd-4c4d-a396-4179aaad1015");
        add("4999f1b7-6d69-40b8-a1d1-72ca93bee991");
        add("4afc0780-42df-4acd-a016-024aab5648d9");
        add("4b1fca1e-7a44-49c3-bb8f-d7178b560e97");
        add("4b402ff1-38c5-4b3e-aaeb-93a4288392e5");
        add("4b6ae922-55c0-461c-b648-b8dca800715a");
        add("4bd8ec87-acf9-4037-9191-99ce112a1915");
        add("4c386869-6362-44ce-a9dd-0c79803e278c");
        add("4c439c6f-3995-4b4a-a391-a59ecb5ff222");
        add("4c71413d-4ad1-4941-bd95-ab7f5f205769");
        add("4ca38816-b390-40d4-8b4a-b7be26ced3ab");
        add("4ca78a8a-b33b-4b0e-97a9-97b832feaf10");
        add("4d8d0791-e4ae-4312-b885-459955242607");
        add("4d9ce0a2-e929-4eb1-a262-000ef6cbbc4c");
        add("4edd7a95-2cf0-49c6-b238-e27b920a2398");
        add("4fc6af12-8c87-4ad4-98a7-81d2f48fac7b");
        add("509bfeb3-57a0-413c-88f4-50566a1c09af");
        add("514d3c05-2b03-4c17-8e31-e27b923be607");
        add("5194d1c4-8927-47c3-83fc-087eb852c4da");
        add("51ac6d66-ebaa-4676-b0d1-521105dc91f9");
        add("52114ac8-d092-4baf-a1ee-3058c53eca1c");
        add("5245fbf4-cc51-4aab-8ed3-b10ec02dad64");
        add("529bd3f6-c3c1-4039-9bf3-a6979d09a14f");
        add("52fe9473-2cc7-4da3-abd5-a18dc8f25da4");
        add("531f889e-6de9-4749-a3bd-00a9b606b9a3");
        add("538f87c3-a48b-4677-82d7-2b6398e27c84");
        add("539a593d-7478-4d9d-bcd6-f06758493694");
        add("543eb0ae-977c-4bfd-b343-91daf65ea724");
        add("55f23fe1-5aae-4dff-b500-419190bfe3ec");
        add("5667fabc-f40f-4b83-ba4c-adf4feca3502");
        add("57346c6d-4330-4589-b20d-5df72ba0d5f7");
        add("58420b76-e974-4103-800c-67922b1cfcc5");
        add("5908e7c9-475e-4d43-8449-a581d86a4d7a");
        add("59708bc8-9d0f-4604-bf62-88a7814eb5d9");
        add("59a80297-4c46-4339-83a4-8ecd110b99ff");
        add("5c175273-9eca-40d5-a0d7-9d9b807eaa89");
        add("5c4c1c6c-a9a7-46a8-b016-4df9257a6031");
        add("5c8d3049-9949-4412-ace1-2907f520b82a");
        add("5cc1e90e-98c9-4a41-be7f-0b81bf53100b");
        add("5d53b336-7f7d-45ed-b77c-a1b6ce8c1a4d");
        add("5de119d0-2dbe-4438-940b-84f869bd3590");
        add("5e3e1b84-96e7-49f0-a641-9b4550942f12");
        add("60c906e1-ba2a-401c-904e-0df3298126b9");
        add("627dd83e-2aff-4ace-8e36-eab115b9c7e0");
        add("63cd1695-7518-4550-bcdf-678c1ea1113e");
        add("644274a5-6521-4c18-b81c-424ed71006ae");
        add("672ad41b-393c-4e4a-b025-ce237a55643b");
        add("6764a297-66e9-4432-ba12-30b16814b578");
        add("677617b4-1746-480e-9c02-8f448c96e20b");
        add("68458226-a0f1-4db8-b8f8-aa664bb4b782");
        add("686fe43c-b210-4f0e-84ed-93f9491dd966");
        add("687f7773-0efb-4af5-a84c-2e6f10383d86");
        add("692d6343-d2ef-442c-b362-aade41ab9ad5");
        add("696501ce-630b-40c2-acb9-f5eca7cbc408");
        add("697cf6dc-9ca8-4c61-9c4a-67729a998f22");
        add("69825862-600e-4a71-9530-76190bfbf8ae");
        add("698b3c58-3458-4c56-84a5-5ea0c9f6765f");
        add("6a1e03a8-ec32-480b-9121-9e337b4553c1");
        add("6b0a8a8a-36af-4398-9942-60598b4e970e");
        add("6b0dee62-e977-4235-91ee-91caf183c8d9");
        add("6c1985d8-c722-489a-a79d-2c7cee2777e6");
        add("6c3dd0ea-64db-4e84-972d-769ec9aae85c");
        add("6c3fdc16-a976-406c-968c-1bdd25e77bd5");
        add("6c8188b6-2929-4572-bd56-86e743e3eda9");
        add("6ccd6dc3-6fc4-45f0-bc47-fd748be96468");
        add("6d5d98d2-d2f7-4d25-8f6b-7bc145214a4f");
        add("6ff20503-3ccd-4cc3-8837-0651f2e0a175");
        add("6fffd16e-5dd5-4512-87dd-c7935787860e");
        add("708403e3-e670-4134-a1cc-958bc0ece1e4");
        add("70c8117e-313c-4cfa-b140-4f7b0342a360");
        add("70e00be4-81ed-40f6-8177-1ddfd0a32ff2");
        add("72725a11-37a2-47eb-b94b-183718d6b029");
        add("727cebad-90af-4456-9986-792f7694aaec");
        add("72d2d617-71a0-407b-89e0-f6d35a408d74");
        add("72ef95de-a83c-4147-8803-480a54a4489c");
        add("73252a25-240c-493a-85b9-ed7eb5973350");
        add("7393e11a-d623-4f62-a04b-1ff4283d34b7");
        add("74e0168d-92ef-4612-913a-7c1dd86e1cf5");
        add("7546ff49-9648-4a0b-af45-ec0c4f0d7044");
        add("75739132-d029-4403-a6f7-8cc908eda751");
        add("7735141d-48dd-4c36-b9d5-07bb1610529b");
        add("7769a507-0041-4b8c-86d9-272f9739dc22");
        add("7782d290-e633-4da8-b041-a15dea3dab4c");
        add("78600eff-30ed-4e6c-939e-744d42ea8fd6");
        add("7a2dbd9f-fe77-4266-9f06-422a2a5918a0");
        add("7af85396-516a-4bf3-9cf7-0febb7639fb8");
        add("7b1dba63-dce9-4a18-8345-c857aeb7f7c9");
        add("7ca15e4f-fb1a-48cf-b058-c75868e72ed3");
        add("7d9661ac-a293-4f5f-8105-39de6ac3e1b3");
        add("7dc44deb-e200-418c-b7b6-be8e4a84dd06");
        add("7e591cc9-863e-4e5a-aab7-3f99d06a26b7");
        add("7eb0317f-92e6-4533-a9e2-ac5b784d109b");
        add("803b0032-048f-475c-b781-e4103802246e");
        add("8057d91e-9b0f-4e26-a236-da7aaf42594e");
        add("8124c91b-83e4-405f-990c-07709a281158");
        add("812d075e-ce73-4848-b9a1-d9b694fc5aaf");
        add("8136ba8b-ce2a-4f8e-9c8f-ddf7c7518b9b");
        add("815fcf74-9bb7-46e4-807a-537ad4bac5c6");
        add("823ac02b-f790-42b2-9bcb-ba36d67edc13");
        add("828fb474-7b67-4f8f-b693-5db247882bea");
        add("8342e709-3e8d-4d89-800d-a3f0b0cf47af");
        add("8388c855-9227-4702-a38a-153d22916abe");
        add("85646667-05a7-4422-af20-5886396dfc2e");
        add("857c2eaf-1fd7-40cd-8198-0bb97ba57d34");
        add("87622e3d-632e-4a0e-b1e4-0f737e8cfdb4");
        add("885d7409-251a-4583-996e-9dd0b9ae24d7");
        add("88c1ee34-fcc6-4136-b8a0-7e18c33fd2dd");
        add("8907e423-7ea2-427f-8111-5e7991bc7096");
        add("895b67a1-8af8-4e69-a3f0-e647e3787d00");
        add("895dd806-fce5-41bf-be4a-0357ca606603");
        add("8a3e0d9a-2f0e-4699-b220-ccf1ea92e132");
        add("8a5a7163-2fc4-4e72-9541-f6e21247d1ee");
        add("8aef68e1-9525-4000-b805-12bb9beb779c");
        add("8b41f45c-d0ce-455c-a88f-257704b3db8c");
        add("8b72745c-17ee-4f48-b72f-0dfff4bdf997");
        add("8b950b41-486d-40b0-8416-79077d0be5d4");
        add("8befe602-594c-4984-b2f7-efaea061d77b");
        add("8c6071ff-c49d-4c28-8955-bc0ec28ab121");
        add("8c79fec4-9535-42a0-aab9-50739e7566e3");
        add("8cd8e1b4-dd93-4959-9057-d088cef3d4ce");
        add("8ce213a6-322d-4fd5-88ea-7962976f9114");
        add("8e0c0b16-7127-4835-9e64-eda3f3972e36");
        add("8e71dade-cdbb-4665-b021-931da2cb0792");
        add("8e77c2a4-d825-4db3-9743-063f193fb9f0");
        add("8efff021-0452-4888-95b3-7465fdbf0b9a");
        add("8f3ae10b-4817-427d-85aa-cc5b672c421b");
        add("90281c86-1a84-4601-bce8-3c3aa1a5d09f");
        add("9102a162-ee65-48e7-a543-c2d6ed0275e6");
        add("9174f2fb-045a-4b2c-915b-36f1572222bd");
        add("9181b4f5-63f1-467e-b157-6744dc4f11b2");
        add("92170198-95a7-4228-ad41-ae34145bde98");
        add("92514280-ad86-4ebe-981b-e2dbd94cb473");
        add("9275b5a9-8526-4dd3-8cf9-e2f730c968cb");
        add("928e11be-b29d-497c-90b5-a1c6c42c548d");
        add("92dbd162-633c-4fe1-8211-290006dba31e");
        add("934e2d44-02ec-4a6a-b23f-2f68429f89dd");
        add("93adc3b6-e435-4f73-9780-5c86a9f8d53b");
        add("93ed0a2c-ab43-47e5-8661-fb9829107bf3");
        add("958cde63-94b3-46a0-82ae-6baa10edc7ec");
        add("97793374-e873-47a6-9e7a-c3300a3d5392");
        add("9859fe2e-0910-4b22-b6b4-f4e139695b0d");
        add("991a7eef-2829-4629-a9fe-5b53aa810327");
        add("9924e9a4-ebbb-4aa0-a930-ab7e1693830d");
        add("9b1d6884-b608-45f2-abf1-d7a2ed227a05");
        add("9b72edeb-dd8e-4afe-ac7a-9df17736b3b9");
        add("9c518f2f-25bf-4efc-98cb-38180919269c");
        add("9c84dd05-fe2e-43ba-861b-5ee1d445ea1b");
        add("9cc7229b-9973-4d84-bddf-897b81410553");
        add("9dd8fc03-c1fb-46d0-9e62-fb0ad6a321a8");
        add("9e05b6d8-df2f-489c-8593-51397b95e706");
        add("9e1e12e8-5e57-4f3f-96a5-d9d2aeb32056");
        add("9f930766-c034-4c10-b7ff-9a1b6bd98d8a");
        add("9fd4fd80-f106-493b-b48d-34bce521a539");
        add("a06e9bc8-783e-4d03-82c2-ce75930058cb");
        add("a13aa275-b01a-4da0-8bd9-29fd3d0852ce");
        add("a1993a50-c36f-42cf-a992-feb259bb1cb3");
        add("a36aa54a-961c-4db1-b769-f8db32c255c4");
        add("a3f1d6fe-ada2-45de-9b76-f94299dbe71e");
        add("a48f55cb-9a8b-4faf-aa8b-345c1babe11c");
        add("a4a0b641-386c-4b8a-81c0-3704c5b54cd2");
        add("a4b2b09a-ec8c-4404-aa9e-c9888317501f");
        add("a4b994d1-a3f3-4a41-b07e-86df3b37eb84");
        add("a4ffc536-edb6-4c1f-a8d4-f5fada0e5472");
        add("a546de32-fb8a-420d-a77c-32dca761706e");
        add("a552df75-6d52-4fe8-b5a5-83e1a26764cc");
        add("a5942704-eee9-4b61-8070-391b886e93c8");
        add("a59b89cb-d505-436f-926c-c3da54ac4b3c");
        add("a5a3bab4-e7a5-48ff-9af5-26e52584d4be");
        add("a5aa652c-59e3-4666-bc56-c25f40219646");
        add("a5db80b6-83a1-4a47-aa2a-c4600467def3");
        add("a6457c2b-7f24-41fb-864f-c4c7b7065aba");
        add("a68aea94-a0ec-4f53-911b-42921e92e651");
        add("a701c4ba-8797-45f5-8dab-a3461697ed86");
        add("a71ca8c7-a0c7-455f-b916-f99213f31dbf");
        add("a8cdfe61-fd2b-46b0-bc5c-197bfbc8c28e");
        add("a8f47e35-c8d4-472f-8fa2-34026feb8155");
        add("a926cdd5-889c-484e-9f8b-a179842e8710");
        add("aa0e149a-8395-4e9b-96f0-b75500028125");
        add("aa425b70-2e36-4b5e-9186-a2978f681b38");
        add("aa55ad7a-9cf3-4d31-9b4b-028a969b1c10");
        add("aa56d835-359f-4d15-bfd3-6a7652566363");
        add("aac4a6a6-731d-4f44-8780-5edcaf9b40f1");
        add("ab35cd79-dc74-40dd-9a62-71d470993598");
        add("ab68b8bf-8674-4bec-a44b-e7e67f5d3ebe");
        add("ac014b8a-c067-4c1b-8a92-f1a062c5b906");
        add("ad6dcb87-ec9c-48a2-a50d-8649593d1a27");
        add("adbaef07-95fe-4c0e-b007-b080107e2d93");
        add("ae3a375d-16f0-4c72-97ce-73878940ce74");
        add("ae5a2465-8287-4aa6-9afd-17c0eb69a20a");
        add("ae6d9098-e21e-49b7-8c57-5a24e469fba4");
        add("af6520ae-1bad-48a0-9de2-4951c7e85ef8");
        add("b166c41b-cf98-41f3-860f-bd909a3a1e47");
        add("b1b7bf3d-02d5-4875-8d19-24b64e154093");
        add("b22b01df-1604-4996-99be-7ca698e4cdfc");
        add("b4b41512-7e44-4932-8349-3be909def8fd");
        add("b4fcc5f0-81b8-40e3-b4bf-c66e90d2fbda");
        add("b5b617a1-e3f5-45b3-a4f4-291d11976368");
        add("b5ead044-5b20-461a-a366-06663d5c872f");
        add("b6ba8f0f-87c5-45ce-b294-220774f04fc2");
        add("b77ba2ea-151c-4897-88ac-92c4a0b28939");
        add("b7dd6064-3b65-4f8e-acfe-2e9ace7cb2b6");
        add("b806eab5-bc67-41de-a480-4f9459fc527a");
        add("b8b0ba43-0e3e-4333-943c-4c3d7a40e052");
        add("ba244485-47f2-4dfa-8542-aa182f1b4748");
        add("ba6bd09d-5fd2-4d5b-97b4-b6b42fcf5fb5");
        add("baf1b14e-f285-4368-918a-d74fb8df10e7");
        add("bafa3a98-fed9-4ef5-be3f-3f2776153613");
        add("bb497ae0-fd84-4c77-b3f3-ac83948d85c2");
        add("bc830ffb-d023-412b-a939-cba29deb12bc");
        add("bcc99fab-9825-4f3f-bd14-6a33ae0f073a");
        add("bce3c3bf-e627-4afe-a8d8-7dbdaf4584ca");
        add("bd1fdf2c-b3c8-4740-ab38-c832a0badd99");
        add("bd533d69-29fc-4d0a-99ac-89d58d0b5a98");
        add("bee4754c-9d8b-4258-acc0-4a9d9f2e2012");
        add("bf2b036e-1d03-4c29-a25c-d6d2638bff02");
        add("c02981b8-333b-45cd-a88d-80dccecf8a16");
        add("c02bbd4e-de18-438c-8b87-8f0c536a2e1b");
        add("c0748ae0-f283-49ad-a70c-2f3dadd190dd");
        add("c151191a-2a6f-4a7c-9c05-9db84b247206");
        add("c23d8044-d9d4-46ce-902a-1f9735ffc0bf");
        add("c2c9078c-38bc-4514-900c-be63f5da4868");
        add("c431d998-19c7-47e5-9223-85627f062a8b");
        add("c434d156-341d-4a4c-a877-ea77f21307a5");
        add("c5166e0e-7311-4190-bda1-69e2516e3f2d");
        add("c54e255f-0dac-46c1-b4e8-a865842db875");
        add("c57353a7-404b-4c29-b926-1335e4d6c1f9");
        add("c770644a-7cd4-4994-a570-4656d167146a");
        add("c795b078-620f-4959-9ffe-3ab8c36681d6");
        add("c8d53dfe-6e65-4f58-9b5c-58ff2bccaeee");
        add("c9135d19-8bc9-4a0e-b61c-e6bdbc05e290");
        add("c958e05c-e8ec-4818-9302-4dfa00439e1f");
        add("c96432ec-2bf2-4929-b8d4-6ed0d57685cc");
        add("c9b805c9-6843-461c-a69d-4bda587520b5");
        add("ca8622c6-6a9b-48d3-9693-3ffd86148eb3");
        add("cb269c28-12c8-40cd-a9f2-b94435dce6d4");
        add("cb5f7c46-fb21-45b1-9fcc-22675fbed031");
        add("cb82d6d6-7137-4c33-bd96-92654e4fff56");
        add("cb9c571e-44a2-4c39-9a63-13fe881ecd37");
        add("cc5e5001-4429-40ae-a3c6-b253c95739ea");
        add("cc9b0943-fb2c-45a9-a398-3fc6ebd6573c");
        add("cdad0673-284c-4ffa-8e59-f57ced06cb75");
        add("ce0c493c-ca4f-4586-b37c-bd3942861c5c");
        add("ce2140f5-e3cb-44f1-8c94-ff22142e1482");
        add("ce5f46bc-ecae-4fa8-bd2d-c6b7f4f93600");
        add("ce8566e2-d351-4267-ad4c-2cdd83cc1d71");
        add("cf373470-150a-488e-84a1-53797eaa3723");
        add("cf3847ef-700d-4074-9811-a244d60ef429");
        add("cf9fced5-3320-437e-9b9a-5019ef20f1de");
        add("cffcdfd5-31a9-4566-bd63-fccca5a5d4e1");
        add("d0141179-f830-41f8-8eca-b2ff65d08f3d");
        add("d02e0ef4-91e4-459d-848f-026ae5c8c070");
        add("d080c428-1154-4472-9e5e-811354ca488b");
        add("d1f21c81-2848-40bd-9072-642fe36c7584");
        add("d298f793-4720-4940-8256-d22ab9b6dff1");
        add("d3435955-f45e-4f4c-88fd-6e3fb40846b0");
        add("d4cf252d-3bdf-4b1f-a6e0-8770111ff932");
        add("d5573e84-ed36-4d41-bd4d-c8e02a3db944");
        add("d6775cb7-e449-4872-8597-c1415ea30ccb");
        add("d6a8f3bf-ae38-4f06-8664-b5032e188717");
        add("d841ed98-3d07-454b-8467-5061f16be7a9");
        add("d847b0d1-c9a6-4231-9b98-dd816c6f352b");
        add("d88b39c3-90c0-4d42-8d98-9cea96a98f04");
        add("d8a88e98-1457-4bb3-a75c-8662094baa77");
        add("d8aedce5-c220-430c-a650-8bf3c32d5646");
        add("d968f6fa-5da6-4e2b-82db-a63ae24918a5");
        add("d9e89d32-1117-45da-a7b0-b66c4791a684");
        add("da8f144a-c7d7-4136-b32a-3527612f4a4d");
        add("da98602e-31a2-449d-8dd2-3dd5e95ac4b6");
        add("db4cacf4-9b13-4e9d-bf60-c3ede736519f");
        add("dbb5d1fb-4d47-4fe0-b699-2ebb06e50ce1");
        add("dc6ab917-3ed6-4bb5-9183-b0f7cf4cd7b2");
        add("dd2566ef-c9d4-4f5d-bc76-4d49bca36041");
        add("dda4e705-b006-4f1f-9202-373d279afdf3");
        add("dda95a68-9dfb-468b-9a2f-4ab43c9c221f");
        add("ddebf112-2d5d-4761-86ce-d1959cfb872b");
        add("de38472e-6b3f-47b4-949a-05af2267505a");
        add("df2ea33b-1901-4a46-b750-a27073da310b");
        add("df3f3b45-2b15-4fea-8932-28229cf13e40");
        add("df70ec81-dac5-49fa-89d4-94ecbc9df6f2");
        add("e0dd8c61-34e2-40fd-bc12-afd721080096");
        add("e108791d-fe70-45b0-bca8-cbb73bbffa31");
        add("e112f925-9e67-4974-ba76-440470b1638c");
        add("e14a594b-ec55-4507-832b-604151ed9b46");
        add("e2f1b49b-3f1a-419d-ba24-2cfa3b86d4ab");
        add("e4ecc452-c27d-4dae-88d1-8f78ea12aa6f");
        add("e6baedf3-d387-4b51-a74a-2af09c3dc284");
        add("e6ec47db-28bd-4e66-9162-8a9a7f95c2f8");
        add("e708206c-5e24-479a-9e82-ac7d831aad70");
        add("e7b29aa4-59a6-43b1-a0fc-70031f45ee90");
        add("e7d88a62-4b0f-4b29-802c-adf9420a70fd");
        add("e7e86388-fe7b-45b3-86d5-3cf7696202d1");
        add("e8c2e203-86eb-403d-bb97-cae59045e16b");
        add("e8c584f9-c586-42cc-98e0-e25185d53df5");
        add("ea19ee5c-e102-4d61-95aa-a11493cd3ca7");
        add("eb14a985-f788-48b2-a73b-738e08ef158e");
        add("ebd317ed-3a71-4384-b967-e80f6463817a");
        add("ec664cdc-9f27-4f3d-9493-2c39e4bde2a6");
        add("ecbb0235-9c8e-4321-a5b4-65360419f093");
        add("ecfd46ba-508c-4164-8d9f-b65e128f40b3");
        add("ed056e29-6aaa-471d-b1d9-e9d25bd1355a");
        add("eda576f4-a6e6-4f01-8574-40ad0c18fdea");
        add("eddd83fd-c60d-41ce-bc5e-2368c5afaefa");
        add("ee4d4e57-81b5-4d8a-9485-c5d2c7469129");
        add("eee2365c-e5e4-4dcc-b620-cc78b24f014d");
        add("eff7da51-d199-4367-afaf-e779455ac18b");
        add("f071eafc-dd65-4922-88c7-70c1916437cf");
        add("f0cf35f1-648e-4da7-ad87-2b065c02236a");
        add("f136d0da-a3f9-4340-94b3-6b78b80dfba2");
        add("f1bb1e00-939e-45cf-8e82-b3dd6b29fa5c");
        add("f2290137-4a71-45ac-8202-516a6956b05a");
        add("f3062506-1eb1-45bb-b14a-345feb527692");
        add("f58661cc-9bc7-4785-a5be-1b727433d3c6");
        add("f6197bdc-20c7-4a63-bbe6-2442a5f84d7c");
        add("f71040ec-ddb7-4cca-a950-aa195d90dbd8");
        add("f80e01f2-ceac-49c0-ad2c-16ae1128c297");
        add("f81fa3a3-b823-4c89-be33-f758261d3a99");
        add("f839dbb9-4919-4d7f-939a-69fdb1068b25");
        add("f881bb29-e859-46d9-9f9f-3fc28618a124");
        add("f93fae3c-797e-4d28-9535-7f240afc795d");
        add("f9ba429c-c68f-476a-a949-fd2fc10f36c9");
        add("fa16f11f-c6a5-42de-9d95-1bcdaef36377");
        add("fa329eeb-de38-416d-9802-ad0f706d5132");
        add("fb282964-9b43-44ae-88c1-669678f5b230");
        add("fbccc490-8348-4c2a-b5b0-a6f457f6a300");
        add("fc48d821-1a0e-4236-8f9f-5826424565de");
        add("fdf939f3-6ae5-40b8-a2ea-0cf97bbcc498");
        add("ff3ac1d1-080d-4d2d-bb4c-95139aee0b4f");
        add("ffe2a399-8a69-43b2-9b04-97c82159dc18");
    }};

    @Test
    public void runa() {
        Map<String, Integer> parmas = new HashMap<>();
        shopList.forEach(shop -> {
            int hashcode = Math.abs(shop.hashCode() % 36);
            System.out.println(hashcode);
            parmas.put(hashcode)
        });
    }

}