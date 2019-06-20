package cn.edu.gdpt.queryphone.bean;

public class qqbean {

    /**
     * error_code : 0
     * reason : success
     * result : {"data":{"conclusion":"[大吉+官运+财运+才艺]如龙得云，青云直上，智谋奋进，才略奏功","analysis":"欲望难足希望高，计谋成功财力豪，猜疑嫉妒性自改，如龙乘云势运开。智能超人贯彻大志，富贵无比，不甘寂寞，叱吒风云之大吉数，但容易发生牢骚及贪心、欲望太多而永不知足，为其缺点。切忌沉迷投机，可免贻误前程。"}}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * data : {"conclusion":"[大吉+官运+财运+才艺]如龙得云，青云直上，智谋奋进，才略奏功","analysis":"欲望难足希望高，计谋成功财力豪，猜疑嫉妒性自改，如龙乘云势运开。智能超人贯彻大志，富贵无比，不甘寂寞，叱吒风云之大吉数，但容易发生牢骚及贪心、欲望太多而永不知足，为其缺点。切忌沉迷投机，可免贻误前程。"}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * conclusion : [大吉+官运+财运+才艺]如龙得云，青云直上，智谋奋进，才略奏功
             * analysis : 欲望难足希望高，计谋成功财力豪，猜疑嫉妒性自改，如龙乘云势运开。智能超人贯彻大志，富贵无比，不甘寂寞，叱吒风云之大吉数，但容易发生牢骚及贪心、欲望太多而永不知足，为其缺点。切忌沉迷投机，可免贻误前程。
             */

            private String conclusion;
            private String analysis;

            public String getConclusion() {
                return conclusion;
            }

            public void setConclusion(String conclusion) {
                this.conclusion = conclusion;
            }

            public String getAnalysis() {
                return analysis;
            }

            public void setAnalysis(String analysis) {
                this.analysis = analysis;
            }
        }
    }
}

